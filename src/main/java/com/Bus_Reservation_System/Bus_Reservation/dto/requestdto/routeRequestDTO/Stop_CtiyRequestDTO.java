package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.routeRequestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stop_CtiyRequestDTO {

    @NotNull
    private Integer city_id;

    @NotBlank
    private String stop_name;

    private LocalTime time;
}