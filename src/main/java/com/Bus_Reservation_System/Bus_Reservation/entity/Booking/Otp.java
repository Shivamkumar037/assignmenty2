package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@ManyToOne
    @Column(name = "userId")
    private User user;
private String otp;
}
