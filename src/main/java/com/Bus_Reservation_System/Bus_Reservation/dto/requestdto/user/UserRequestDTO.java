package com.Bus_Reservation_System.Bus_Reservation.dto.requestdto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.CancleBooking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Otp;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class UserRequestDTO {

    @Size(min = 3,max = 20,message = "Name can not be Lessthen 3 or grater 20")
    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 10,max = 16)
    private String phone;
    @NotBlank
    private String  password;
    private LocalDate dob;
    private String aadhar;
}
