package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

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
public class BusOperater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busoperater_id;

    private String operater_name;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "busOperater", fetch = FetchType.LAZY)
    private List<Bus> busList;

}
