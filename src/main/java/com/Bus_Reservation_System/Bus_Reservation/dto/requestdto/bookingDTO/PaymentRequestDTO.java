package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDTO {

    @Min(0)
    @Max(999999)
    private double ammount;

    private String payment_method;

    private boolean payment_status;

    @NotBlank
    private String transection_id;

    @NotNull
    private Integer booking_id;
}