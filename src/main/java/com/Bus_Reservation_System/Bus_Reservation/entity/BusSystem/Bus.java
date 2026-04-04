package com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.Bustype;
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
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(unique = true)
    private String busNo;
    private Bustype bustype;
    private Integer totalSeats;
    private boolean status=true;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_Id")
    private User drivar;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "conductor_Id")
    private User conductor;

    public boolean isStatus() {
        return status;
    }

    @OneToMany(mappedBy = "bus")
    private List<Seat> seatList;
    @OneToMany(mappedBy = "bus")
    private List<BusSchedule> busSchedules;
}
