package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequestDTO {

    @NotNull
    private Integer sourceId;

    @NotNull
    private Integer destinationId;

    @NotNull
    private double disstance;

    private LocalTime time;
}