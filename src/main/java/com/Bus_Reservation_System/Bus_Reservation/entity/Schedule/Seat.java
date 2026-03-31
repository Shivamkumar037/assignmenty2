package com.Bus_Reservation_System.Bus_Reservation.entity.Schedule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.BookingPassenger;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.SeatType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seat_id;

    private String seat_no;

    private SeatType seat_type;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name ="bus_id")
    private Bus bus;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BookingPassenger> bookingPassengerList;

}
