package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusOperaterRequestDTO {

    private String operater_name;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;
}