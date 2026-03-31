package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO.Stop_CtiyRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO.Stop_CtiyResponseDTO;
import java.util.List;

public interface StopCityService {

   Stop_CtiyResponseDTO addStopToCity(Stop_CtiyRequestDTO  request);

    Stop_CtiyResponseDTO updateStopDetails(Integer stopId, Stop_CtiyRequestDTO request);

    Stop_CtiyResponseDTO getStopById(Integer stopId);

    List<Stop_CtiyResponseDTO> getStopsByCityId(Integer cityId);

    List<Stop_CtiyResponseDTO> getAllStops(int pageNumber, int pageSize);

    void deleteStop(Integer stopId);

    List<Stop_CtiyResponseDTO> getStopsByName(String stopName);
}