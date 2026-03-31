package com.Bus_Reservation_System.Bus_Reservation.entity.Route;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Stop_Ctiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stop_id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City  city;
    private String stop_name;
    private LocalTime time ;





}
