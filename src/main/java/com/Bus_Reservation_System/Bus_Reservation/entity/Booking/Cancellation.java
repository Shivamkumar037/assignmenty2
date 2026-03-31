package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Cancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cancellation_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking")
    private Booking booking;

    private LocalDateTime cancellation_date = LocalDateTime.now();

    private double refound_ammount;

    private boolean refound_status=false;

}
