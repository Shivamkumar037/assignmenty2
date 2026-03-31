package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopRequestDTO {

    private Integer sequence;

    @NotNull
    private Integer route_id;

    @NotNull
    private Integer stop_city_id;

    private double distance_from_start;
}