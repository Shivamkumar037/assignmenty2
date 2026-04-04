package com.Bus_Reservation_System.Bus_Reservation.service.structer;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user.RouteRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.RouteResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user.SouceDestinationRequestDto;

import java.util.List;

public interface RouteService {
    RouteResponseDTO createRoute(RouteRequestDTO routeRequestDTO);
    RouteResponseDTO updateRoute(Integer id,RouteRequestDTO routeRequestDTO);
    RouteResponseDTO deleteRoute(Integer id);
    RouteResponseDTO getRoute(Integer id);
    List<RouteResponseDTO> getRoutes(Integer pageno, Integer pagesize);
    List<RouteResponseDTO> getRoutesBySourceAndDestination(SouceDestinationRequestDto souceDestinationRequestDto);

}
