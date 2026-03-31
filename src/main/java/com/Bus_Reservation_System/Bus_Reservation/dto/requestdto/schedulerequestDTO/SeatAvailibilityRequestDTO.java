package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.schedulerequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatAvailibilityRequestDTO {

    private boolean status;

    @NotNull
    private Integer seat_id;

    @NotNull
    private Integer schedule_id;
}