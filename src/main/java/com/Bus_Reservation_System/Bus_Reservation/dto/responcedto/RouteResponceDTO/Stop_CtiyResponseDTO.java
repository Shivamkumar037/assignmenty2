package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.RouteResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stop_CtiyResponseDTO {

    private Integer stop_id;

    private Integer city_id;

    private String stop_name;

    private LocalTime time;
}