package com.Bus_Reservation_System.Bus_Reservation.dto.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO {

    private Integer bookingid;

    private Integer userId;

    private LocalDateTime bookingdatetime;

    private double totalammount;

    private boolean bookingstatus;

    private Integer scheduleId;
}