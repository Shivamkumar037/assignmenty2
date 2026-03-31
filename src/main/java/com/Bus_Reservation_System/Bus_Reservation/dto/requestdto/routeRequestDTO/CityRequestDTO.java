package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequestDTO {

    @NotBlank
    private String city;

    @NotBlank
    private String state;
}