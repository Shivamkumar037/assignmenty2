package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopResponceDTO {
    private String stopName;
    private Double distanceFromSource;

}
