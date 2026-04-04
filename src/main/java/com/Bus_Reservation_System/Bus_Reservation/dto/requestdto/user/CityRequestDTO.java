package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDTO {
    private String name;
    private String state;
}
