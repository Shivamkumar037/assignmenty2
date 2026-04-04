package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Passanger;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
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
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentId")
    private Payment payment;
    private String reason;
    private Date date;
    private LocalTime time;
    private BookingStatus status;

    private  double refound;
@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name = "booking_id")
private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "schedule_id")
private BusSchedule busSchedule;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "passanger_id")
    private Passanger passanger;

}
