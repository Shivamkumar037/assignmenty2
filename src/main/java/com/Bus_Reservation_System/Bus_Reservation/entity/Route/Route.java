package com.Bus_Reservation_System.Bus_Reservation.entity.Route;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
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
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "source_cityId")
    private City source;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_cityId")
    private City destination;

    private  double distance;

    private double priceprkm;

    @OneToMany(mappedBy = "route")
   private List<Stop> stops;
    @OneToMany(mappedBy = "route")
    private List<BusSchedule> busSchedules;






}
