package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO.SeatAvailibilityResponseDTO;

import java.util.List;

public interface SeatAvailabilityService {

    SeatAvailibilityResponseDTO updateSeatStatus(Integer scheduleId, Integer seatId, boolean status);

    List<SeatAvailibilityResponseDTO> getAvailableSeatsBySchedule(Integer scheduleId);

    List<SeatAvailibilityResponseDTO> getAllSeatStatusesBySchedule(Integer scheduleId);

    SeatAvailibilityResponseDTO getSeatAvailabilityDetails(Integer scheduleId, Integer seatId);

    void initializeSeatsForSchedule(Integer scheduleId, Integer busId);

    boolean checkSeatAvailability(Integer scheduleId, Integer seatId);
}