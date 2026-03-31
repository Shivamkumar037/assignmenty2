package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.RouteRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;

import java.util.List;

public interface RouteService {

   RouteResponseDTO createRoute(RouteRequestDTO request);

    RouteResponseDTO updateRoute(Integer routeId, RouteRequestDTO request);

    RouteResponseDTO getRouteById(Integer routeId);

    List<RouteResponseDTO> getRoutesBySourceAndDestination(Integer sourceCityId, Integer destinationCityId);

    List<RouteResponseDTO> getAllRoutes(int pageNumber, int pageSize);

    void deleteRoute(Integer routeId);

    List<RouteResponseDTO> getRoutesBySource(Integer sourceCityId);
}