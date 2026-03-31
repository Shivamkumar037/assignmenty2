package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {

    private Integer payment_id;

    private double ammount;

    private String payment_method;

    private boolean payment_status;

    private String transection_id;

    private Integer booking_id;
}