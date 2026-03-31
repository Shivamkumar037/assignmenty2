package com.Bus_Reservation_System.Bus_Reservation.entity.Route;

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
public class RouteStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stop_id;

    private  Integer sequence;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "stop_city_id")
    private Stop_Ctiy stopCtiy;

    private  double distance_from_start;
}
