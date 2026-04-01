package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.CancleBooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passanger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String name;
     private  String aadhar;
     private String address;
     private String phone;

     @ManyToOne
    @Column(name = "seat_id")
    private  Seat seat;

    @ManyToOne
    @Column(name = "bookingId")
    private Booking booking;
@OneToMany(mappedBy = "passanger")
    private CancleBooking cancleBooking;

}
