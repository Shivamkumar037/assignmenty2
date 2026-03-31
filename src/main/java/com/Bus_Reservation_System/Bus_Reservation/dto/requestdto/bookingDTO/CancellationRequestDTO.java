package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancellationRequestDTO {

    @NotNull
    private Integer booking_id;

    private double refound_ammount;

    private boolean refound_status;
}