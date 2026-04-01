package com.Bus_Reservation_System.Bus_Reservation.entity.Route;

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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String state;
    @OneToMany(mappedBy = "source")
    private List<Route> sourceRoute;
    @OneToMany(mappedBy = "destination")
    private List<Route> destimationRoute;
}
