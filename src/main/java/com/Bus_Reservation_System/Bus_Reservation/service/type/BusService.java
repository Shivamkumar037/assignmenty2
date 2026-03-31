package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO.BusRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO.BusResponseDTO;

import java.util.List;

public interface BusService {
    BusResponseDTO createBus(BusRequestDTO busRequest);
    BusResponseDTO updateBus(Integer busId, BusRequestDTO busRequest);
    BusResponseDTO deleteBus(Integer busId);
    BusResponseDTO findBusById(Integer busId);
    List<BusResponseDTO> findAllBuses(int pageNumber, int pageSize);
}