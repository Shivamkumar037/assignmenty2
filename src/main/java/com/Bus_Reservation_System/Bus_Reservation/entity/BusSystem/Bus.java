package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bus_id;

    @NotBlank
    private String bus_number;

    @NotBlank
    private Bustype bus_type;

    @NotNull
    private Integer total_seat;

    private boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_operater")
    private BusOperater busOperater;

    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BusSchedule> busScheduleList;

    public  boolean getStatus(){
        return this.status;
    }

}
