package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.SeatType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequestDTO {

    @NotBlank
    private String seat_no;

    @NotNull
    private SeatType seat_type;

    @NotNull
    private Integer bus_id;
}