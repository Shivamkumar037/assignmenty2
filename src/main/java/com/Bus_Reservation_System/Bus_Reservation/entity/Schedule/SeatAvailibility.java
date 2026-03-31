package com.Bus_Reservation_System.Bus_Reservation.entity.Schedule;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class SeatAvailibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bus_availbility_id;

    private boolean status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private BusSchedule busschedule;



}
