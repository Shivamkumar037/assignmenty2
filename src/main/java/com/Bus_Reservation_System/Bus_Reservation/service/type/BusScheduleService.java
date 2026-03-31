package com.Bus_Reservation_System.Bus_Reservation.service.type;

import com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO.BusScheduleRequestDTO;
import com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO.BusScheduleResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface BusScheduleService {

   BusScheduleResponseDTO createSchedule(BusScheduleRequestDTO request);

    BusScheduleResponseDTO updateSchedule(Integer scheduleId, BusScheduleRequestDTO request);

    BusScheduleResponseDTO getScheduleById(Integer scheduleId);

    List<BusScheduleResponseDTO> getSchedulesByRouteAndDate(Integer routeId, LocalDate date);

    List<BusScheduleResponseDTO> getSchedulesByBusId(Integer busId);

    List<BusScheduleResponseDTO> getAllSchedules(int pageNumber, int pageSize);

    void deleteSchedule(Integer scheduleId);

    void updateAvailableSeats(Integer scheduleId, Integer seatsToReduce);
    
    List<BusScheduleResponseDTO> findSchedulesBetweenCities(Integer sourceCityId, Integer destinationCityId, LocalDate date);
}