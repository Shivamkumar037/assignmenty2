package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.BusSystemRequestDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusRequestDTO {

    @NotBlank
    private String bus_number;

    @NotNull
    private Bustype bus_type;

    @NotNull
    private Integer total_seat;

    private boolean status=true;

    @NotNull
    private Integer bus_operater_id;
}