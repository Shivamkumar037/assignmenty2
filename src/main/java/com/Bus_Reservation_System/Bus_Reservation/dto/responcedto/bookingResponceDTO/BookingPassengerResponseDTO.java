package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.bookingResponceDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPassengerResponseDTO {

    private Integer passenger_id;

    private Integer booking_id;

    private String passenger_name;

    private Integer age;

    private Gender gender;

    private Integer seat_id;
}