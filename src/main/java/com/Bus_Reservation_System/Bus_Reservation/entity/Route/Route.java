package com.Bus_Reservation_System.Bus_Reservation.entity.Route;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer route_id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "source")
    private City source;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "destination")
    private City destination;

    @NotNull(message = "Distance Can Not Be NUll")
    private double disstance;

    private LocalTime time;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BusSchedule> busScheduleList;
}
