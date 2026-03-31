package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CancellationResponseDTO {

    private Integer cancellation_id;

    private Integer booking_id;

    private LocalDateTime cancellation_date;

    private double refound_ammount;

    private boolean refound_status;
}