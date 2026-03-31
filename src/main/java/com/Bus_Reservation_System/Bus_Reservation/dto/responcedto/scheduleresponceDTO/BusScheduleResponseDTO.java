package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.scheduleresponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusScheduleResponseDTO {

    private Integer bus_schedule_id;

    private LocalTime arrival_time;

    private LocalTime departure_time;

    private Integer available_seat;

    private LocalDate travel_date;

    private Integer bus_id;

    private Integer route_id;
}