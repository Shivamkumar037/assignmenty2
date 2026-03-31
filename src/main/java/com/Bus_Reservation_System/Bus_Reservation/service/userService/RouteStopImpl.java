package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.RouteStopRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.RouteStopResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.RouteStop;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Stop_Ctiy;
import com.Bus_Reservation_System.Bus_Reservation.exception.CityNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.exception.RouteNotFoundException;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.RouteStopRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.RouteRepo.Stop_CityRepo;
import com.Bus_Reservation_System.Bus_Reservation.service.type.RouteStopService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteStopImpl implements RouteStopService {

    private final RouteStopRepo routeStopRepo;
    private final Stop_CityRepo stopCityRepo;
    private final RouteRepo routeRepo;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public RouteStopResponseDTO addStopToRoute(RouteStopRequestDTO request) {
     RouteStop routeStop= requestMapping(request,new RouteStop());
     routeStop=routeStopRepo.save(routeStop);
        return responceMapping(routeStop);
    }


    @Override
    @Transactional
    public RouteStopResponseDTO updateStopDetails(Integer stopId, RouteStopRequestDTO request) {
        RouteStop stop = routeStopRepo.findById(stopId)
                .orElseThrow(() -> new RouteNotFoundException("Stop Not Found"));
stop=requestMapping(request,stop);
return responceMapping(stop);
    }

    @Override
    public List<RouteStopResponseDTO> getStopsByRouteId(Integer routeId) {
        Route route = routeRepo.findById(routeId)
                .orElseThrow(() -> new RouteNotFoundException("Route Not Found"));

        List<RouteStop> stops = routeStopRepo.findAllByRoute(route);

        return stops.stream()
                .map(stop -> responceMapping(stop))
                .toList();
    }

    @Override
    public List<RouteStopResponseDTO> getStopsByRouteIdOrderedBySequence(Integer routeId) {
        List<RouteStop> stops = routeStopRepo.findByRoute_RouteIdOrderBySequenceAsc(routeId);

        return stops.stream()
                .map(stop -> responceMapping(stop))
                .toList();
    }

    @Override
    @Transactional
    public void removeStopFromRoute(Integer stopId) {
        RouteStop stop = routeStopRepo.findById(stopId)
                .orElseThrow(() -> new RouteNotFoundException("Stop Not Found"));
        routeStopRepo.delete(stop);
    }

    @Override
    public RouteStopResponseDTO getStopById(Integer stopId) {
        RouteStop stop = routeStopRepo.findById(stopId)
                .orElseThrow(() -> new RouteNotFoundException("Stop Not Found"));
        return responceMapping(stop);
    }

    @Override
    @Transactional
    public void updateStopSequence(Integer stopId, Integer newSequence) {
        RouteStop stop = routeStopRepo.findById(stopId)
                .orElseThrow(() -> new RouteNotFoundException("Stop Not Found"));
        stop.setSequence(newSequence);
        routeStopRepo.save(stop);
    }

    RouteStop requestMapping(RouteStopRequestDTO request,RouteStop routeStop){
        if(request.getRoute_id()!=null){
            Route route= routeRepo.findById(request.getRoute_id()).orElseThrow(()-> new RouteNotFoundException("Route Not Found"));
            routeStop.setRoute(route);
        }

        if(request.getStop_city_id()!=null){
            Stop_Ctiy stopCtiy=stopCityRepo.findById(request.getStop_city_id()).orElseThrow(()-> new RouteNotFoundException(" Not Found Stop City"));
            routeStop.setStopCtiy(stopCtiy);
        }
        routeStop.setSequence(request.getSequence());
        routeStop.setDistance_from_start(request.getDistance_from_start());
        return routeStop;
    }

    RouteStopResponseDTO responceMapping(RouteStop routeStop){
        RouteStopResponseDTO responseDTO=new RouteStopResponseDTO();
        responseDTO.setRoute_id(routeStop.getRoute().getRoute_id());
        responseDTO.setSequence(routeStop.getSequence());
        responseDTO.setDistance_from_start(routeStop.getDistance_from_start());
        responseDTO.setStop_id(routeStop.getStop_id());
        responseDTO.setStop_city_id(routeStop.getStopCtiy().getStop_id());

        return responseDTO;
    }
}