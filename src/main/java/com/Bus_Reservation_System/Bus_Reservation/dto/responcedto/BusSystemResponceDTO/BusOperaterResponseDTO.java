package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.BusSystemResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusOperaterResponseDTO {

    private Integer busoperater_id;

    private String operater_name;

    private String phone;

    private String address;
}