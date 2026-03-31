package com.Bus_Reservation_System.Bus_Reservation.service.userService;

import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO.SeatAvailibilityResponseDTO;
import com.Bus_Reservation_System.Bus_Reservation.service.type.SeatAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SeatAvailbilityServiceImpl implements SeatAvailabilityService {

    @Override
    public SeatAvailibilityResponseDTO updateSeatStatus(Integer scheduleId, Integer seatId, boolean status) {

        return null;
    }

    @Override
    public List<SeatAvailibilityResponseDTO> getAvailableSeatsBySchedule(Integer scheduleId) {

        return List.of();
    }

    @Override
    public List<SeatAvailibilityResponseDTO> getAllSeatStatusesBySchedule(Integer scheduleId) {

        return List.of();
    }

    @Override
    public SeatAvailibilityResponseDTO getSeatAvailabilityDetails(Integer scheduleId, Integer seatId) {

        return null;
    }

    @Override
    public void initializeSeatsForSchedule(Integer scheduleId, Integer busId) {

    }

    @Override
    public boolean checkSeatAvailability(Integer scheduleId, Integer seatId) {

        return false;
    }

}
