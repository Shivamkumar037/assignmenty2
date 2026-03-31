package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponseDTO {

    private Integer route_id;

    private Integer sourceId;

    private String sourceCityName;

    private Integer destinationId;

    private String destinationCityName;

    private double disstance;

    private LocalTime time;
}