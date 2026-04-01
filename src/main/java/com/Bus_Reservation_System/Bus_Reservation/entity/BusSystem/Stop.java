package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

import com.Bus_Reservation_System.Bus_Reservation.entity.Route.Route;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private  String stopName;
    @NonNull
    private double distanceFromSource;
    @NotNull
    private double price;

    @ManyToOne
    @Column(name = "route_id")
    private Route route;

}
