package com.Bus_Reservation_System.Bus_Reservation.entity.Schedule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bus_schedule_id;

    private LocalTime arrival_time;


    private LocalTime departure_time;

    private Integer available_seat;

    private LocalDate travel_date;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id")
    private Bus bus;


    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "Route_id")
    private Route route;

    @OneToMany(mappedBy = "busschedule", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Booking> bookingList;
}
