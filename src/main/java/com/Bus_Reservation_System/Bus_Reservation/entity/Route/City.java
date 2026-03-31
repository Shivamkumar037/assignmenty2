package com.Bus_Reservation_System.Bus_Reservation.entity.Route;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer city_id;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Stop_Ctiy> stopCtiyList;
}
