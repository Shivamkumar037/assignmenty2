package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponceDTO {
    private Integer id;
    private String name;
    private  String state;
}
