package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopResponseDTO {

    private Integer stop_id;

    private Integer sequence;

    private Integer route_id;

    private Integer stop_city_id;

    private double distance_from_start;
}