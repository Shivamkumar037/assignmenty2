package com.Bus_Reservation_System.Bus_Reservation.entity.Schedule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.SeatAvailability;
import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.Day;
import jakarta.persistence.*;
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
@AllArgsConstructor
@NoArgsConstructor
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Day travelDay;
    private LocalDate travelDate;
    private LocalTime starting;
    private LocalTime ending;
    private double totalHourse;
    @ManyToOne
    @Column(name = "bus_id")
    private Bus bus;
    @ManyToOne
    @Column(name = "route_id")
    private Route route;
    @OneToMany(mappedBy = "busSchedule")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "busSchedule")
    private List<SeatAvailability> seatAvailabilities;
}
