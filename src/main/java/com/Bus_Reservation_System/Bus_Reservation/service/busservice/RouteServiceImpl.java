package com.Bus_Reservation_System.Bus_Reservation.service.busservice;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.RouteRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.SouceDestinationRequestDto;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo.StopRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.structer.RouteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepo routeRepo;
    private final CityRepo cityRepo;
    private final StopRepo stopRepo;

    @Override
    public RouteResponseDTO createRoute(RouteRequestDTO routeRequestDTO) {
        Route route = routeMapper(routeRequestDTO, new Route());
        route = routeRepo.save(route);

        saveStop(route, route.getSource().getName(), 0.0);
        saveStop(route, route.getDestination().getName(), route.getDistance());

        return responseMapper(route);
    }

    private void saveStop(Route route, String name, double distance) {
        Stop stop = new Stop();
        stop.setRoute(route);
        stop.setStopName(name);
        stop.setDistanceFromSource(distance);
        stopRepo.save(stop);
    }

    @Override
    public RouteResponseDTO updateRoute(Integer id, RouteRequestDTO routeRequestDTO) {
        Route route = routeRepo.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        route = routeMapper(routeRequestDTO, route);
        route = routeRepo.save(route);
        return responseMapper(route);
    }

    @Override
    public RouteResponseDTO deleteRoute(Integer id) {
        Route route = routeRepo.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        routeRepo.delete(route);
        return responseMapper(route);
    }

    @Override
    public RouteResponseDTO getRoute(Integer id) {
        Route route = routeRepo.findById(id).orElseThrow(() -> new RuntimeException("Route not found"));
        return responseMapper(route);
    }

    @Override
    public List<RouteResponseDTO> getRoutes(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<Route> routes = routeRepo.findAll(pageable);
        return routes.getContent().stream().map(this::responseMapper).toList();
    }

    @Override
    public List<RouteResponseDTO> getRoutesBySourceAndDestination(SouceDestinationRequestDto request) {
        String src = request.getSource().trim();
        String dest = request.getDestination().trim();

        List<Integer> routeIds = routeRepo.findRouteIdsByStops(src, dest);
        if (routeIds.isEmpty()) {
            return new ArrayList<>();
        }

        List<Route> routeList = routeRepo.findAllById(routeIds);

        return routeList.stream()
                .map(route -> mapToSubRouteResponse(route, src, dest))
                .toList();
    }

    private RouteResponseDTO responseMapper(Route route) {
        RouteResponseDTO dto = new RouteResponseDTO();
        dto.setId(route.getId());
        dto.setDistance(route.getDistance());
        dto.setSourceCityName(route.getSource().getName());
        dto.setDestinationCityName(route.getDestination().getName());
        dto.setPrice(route.getDistance() * route.getPriceprkm());
        return dto;
    }

    private Route routeMapper(RouteRequestDTO dto, Route route) {
        if (dto.getSourceid() != null && dto.getDestinationid() != null) {
            City source = cityRepo.findById(dto.getSourceid())
                    .orElseThrow(() -> new RuntimeException("Source city not found"));
            City destination = cityRepo.findById(dto.getDestinationid())
                    .orElseThrow(() -> new RuntimeException("Destination city not found"));
            route.setSource(source);
            route.setDestination(destination);
        } else {
            throw new RuntimeException("Source or Destination ID missing");
        }
        route.setPriceprkm(dto.getPrice());
        route.setDistance(dto.getDistance());
        return route;
    }

    private RouteResponseDTO mapToSubRouteResponse(Route route, String src, String dest) {
        List<Stop> stops = route.getStops();

        Stop sourceStop = stops.stream()
                .filter(s -> s.getStopName().equalsIgnoreCase(src))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Source stop not found"));

        Stop destStop = stops.stream()
                .filter(s -> s.getStopName().equalsIgnoreCase(dest))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Destination stop not found"));

        if (sourceStop.getDistanceFromSource() > destStop.getDistanceFromSource()) {
            throw new RuntimeException("Invalid route direction");
        }

        double travelDistance = destStop.getDistanceFromSource() - sourceStop.getDistanceFromSource();

        RouteResponseDTO dto = new RouteResponseDTO();
        dto.setId(route.getId());
        dto.setSourceCityName(src);
        dto.setDestinationCityName(dest);
        dto.setDistance(travelDistance);
        dto.setPrice(travelDistance * route.getPriceprkm());

        return dto;
    }
}