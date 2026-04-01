package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Passanger;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancleBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;
    private String reason;
    private Date date;
    private LocalTime time;
    private BookingStatus status;

    private  double refound;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    private Passanger passanger;

}
