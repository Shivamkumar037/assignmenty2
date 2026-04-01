package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean isAvailable= true;
    private Integer seatNo;
    @ManyToOne
    @Column(name = "seat_no")
    private  Seat seat;

    @ManyToOne
    @Column(name = "schedule_id")
    private BusSchedule busSchedule;
}
