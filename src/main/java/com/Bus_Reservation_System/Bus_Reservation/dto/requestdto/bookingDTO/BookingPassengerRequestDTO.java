package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.bookingDTO;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingPassengerRequestDTO {

    @NotNull
    private Integer booking_id;

    @NotBlank
    private String passenger_name;

    private Integer age;

    private Gender gender;

    @NotNull
    private Integer seat_id;
}