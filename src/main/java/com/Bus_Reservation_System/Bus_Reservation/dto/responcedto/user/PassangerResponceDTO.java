package com.Bus_Reservation_System.Bus_Reservation.dto.responcedto.user;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassangerResponceDTO {
    private Integer id;
    private String name;
    private String aadhar;
    private String phone;
    private String email;
    private String address;
    private Booking booking;
    private Seat seat;
}
