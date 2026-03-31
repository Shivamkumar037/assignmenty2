package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusScheduleRequestDTO {

    private LocalTime arrival_time;

    private LocalTime departure_time;

    private Integer available_seat;

    private LocalDate travel_date;

    @NotNull
    private Integer bus_id;

    @NotNull
    private Integer route_id;
}