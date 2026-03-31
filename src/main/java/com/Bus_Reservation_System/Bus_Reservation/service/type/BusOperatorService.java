package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO.BusOperaterRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO.BusOperaterResponseDTO;

import java.util.List;

public interface BusOperatorService {
   BusOperaterResponseDTO createOperator(BusOperaterRequestDTO request);
    BusOperaterResponseDTO  updateOperator(Integer id, BusOperaterRequestDTO  request);
    void deleteOperator(Integer id);
    BusOperaterResponseDTO  findOperatorById(Integer id);
    List<BusOperaterResponseDTO > findAllOperators(int pageNumber, int pageSize);
}