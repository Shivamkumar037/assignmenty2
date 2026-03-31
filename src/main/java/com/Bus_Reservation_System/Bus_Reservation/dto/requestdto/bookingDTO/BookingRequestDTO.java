package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer scheduleId;

    @NotNull
    private double totalammount;

    private boolean bookingstatus;
}