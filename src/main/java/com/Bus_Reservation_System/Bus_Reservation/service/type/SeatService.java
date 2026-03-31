package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO.SeatRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO.SeatResponseDTO;

import java.util.List;

public interface SeatService {

    SeatResponseDTO addSeatToBus(SeatRequestDTO request);

    SeatResponseDTO updateSeatDetails(Integer seatId, SeatRequestDTO request);

    SeatResponseDTO getSeatById(Integer seatId);

    List<SeatResponseDTO> getSeatsByBusId(Integer busId);

   Integer getAvailableSeatsByBusId(Integer busId);

    void deleteSeat(Integer seatId);

    boolean isSeatAvailable(Integer seatId, Integer scheduleId);

    List<SeatResponseDTO> addBulkSeats(List<SeatRequestDTO> requests);
}