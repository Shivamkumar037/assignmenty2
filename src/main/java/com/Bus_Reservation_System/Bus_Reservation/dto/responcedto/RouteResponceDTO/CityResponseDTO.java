package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityResponseDTO {

    private Integer city_id;

    private String city;

    private String state;
}