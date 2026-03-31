package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.RouteStopRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.RouteStopResponseDTO;
import java.util.List;

public interface RouteStopService {

    RouteStopResponseDTO addStopToRoute(RouteStopRequestDTO request);

    RouteStopResponseDTO updateStopDetails(Integer stopId, RouteStopRequestDTO request);

    List<RouteStopResponseDTO> getStopsByRouteId(Integer routeId);

    List<RouteStopResponseDTO> getStopsByRouteIdOrderedBySequence(Integer routeId);

    void removeStopFromRoute(Integer stopId);

    RouteStopResponseDTO getStopById(Integer stopId);

    void updateStopSequence(Integer stopId, Integer newSequence);
}