package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingid;

    @ManyToOne(fetch = FetchType.LAZY
            )
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime bookingdatetime = LocalDateTime.now();

    @NotNull
    private double totalammount;

    private boolean bookingstatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private BusSchedule busschedule;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Cancellation> cancellationList;

}
