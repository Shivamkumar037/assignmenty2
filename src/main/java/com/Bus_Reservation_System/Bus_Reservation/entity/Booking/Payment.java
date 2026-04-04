package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import com.Bus_Reservation_System.Bus_Reservation.entity.type.Method;
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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double ammount;
    private String transectionId;
    private Method method;
    @OneToMany(mappedBy = "payment")
    private List<Booking> bookings;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private CancleBooking cancleBooking;
}
