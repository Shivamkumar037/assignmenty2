package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteRequestDTO {
    private Integer sourceid;
    private Integer destinationid;
    private  double price;
    private double distance;
}
