package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.RouteRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.City;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.exception.CityNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.RouteNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.RouteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
private  final RouteRepo routeRepo;
    private final CityRepo cityRepo;
    @Override
    @Transactional   public RouteResponseDTO createRoute(RouteRequestDTO request) {
        Route route = requestMapping(request,new Route());
       route= routeRepo.save(route);
        return responceMapping(route);
    }

    @Override
    @Transactional
    public RouteResponseDTO updateRoute(Integer routeId, RouteRequestDTO request) {
        Route route = routeRepo.findById(routeId)
                .orElseThrow(() -> new RouteNotFoundException("Route Not Found"));
        route= requestMapping(request,route);
        Route updatedRoute = routeRepo.save(route);
        return responceMapping(updatedRoute);
    }

    @Override
    public RouteResponseDTO getRouteById(Integer routeId) {
        Route route =routeRepo.findById(routeId).orElseThrow(()-> new RouteNotFoundException("Route Not Found"));
        return responceMapping(route);
    }

    @Override
    public List<RouteResponseDTO> getRoutesBySourceAndDestination(Integer sourceCityId, Integer destinationCityId) {
        if(!cityRepo.existsById(sourceCityId) || !cityRepo.existsById(destinationCityId)) {
            throw new CityNotFoundException("Source or Destination city ID is invalid");
        }

        List<Route> routeList = routeRepo.getRoutesBySourceAndDestination(sourceCityId, destinationCityId);
        if(routeList.isEmpty()){
            throw new RouteNotFoundException("No Route found for given cities");
        }
        return routeList.stream()
                .map(route ->responceMapping(route))
                .toList();
    }

    @Override
    public List<RouteResponseDTO> getAllRoutes(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Route> page=routeRepo.findAll(pageable);

        return page.getContent().stream().map(route->responceMapping(route)).toList();
    }

    @Override
    public void deleteRoute(Integer routeId) {
        Route route =routeRepo.findById(routeId).orElseThrow(()-> new RouteNotFoundException("Route Not Found"));
routeRepo.delete(route);
    }

    @Override
    public List<RouteResponseDTO> getRoutesBySource(Integer sourceCityId) {

        City sourceCity = cityRepo.findById(sourceCityId)
                .orElseThrow(() -> new CityNotFoundException("Source City Not Found"));

        List<Route> routeList = routeRepo.findAllBySource(sourceCity);

        return routeList.stream()
                .map(route -> responceMapping(route))
                .toList();
    }
    private RouteResponseDTO responceMapping(Route route) {
        RouteResponseDTO responseDTO=new RouteResponseDTO();
        responseDTO.setRoute_id(route.getRoute_id());
        responseDTO.setTime(route.getTime());
        responseDTO.setDisstance(route.getDisstance());
        responseDTO.setSourceId(route.getSource().getCity_id());
        responseDTO.setDestinationId(route.getDestination().getCity_id());
        return responseDTO;
    }

    Route requestMapping(RouteRequestDTO request,Route route){
        if(request.getSourceId()!=null){
            City source = cityRepo.findById(request.getSourceId())
                    .orElseThrow(() -> new CityNotFoundException("Source City Not Found"));
            route.setSource(source);
        }
        if(request.getDestinationId()!=null){
            City destination = cityRepo.findById(request.getDestinationId())
                    .orElseThrow(() -> new CityNotFoundException("Destination City Not Found"));
            route.setDestination(destination);
        }
        route.setDisstance(request.getDisstance());
        route.setTime(request.getTime());
        return route;


    }
}
