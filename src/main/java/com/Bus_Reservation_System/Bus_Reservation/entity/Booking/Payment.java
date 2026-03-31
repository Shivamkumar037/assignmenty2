package com.Bus_Reservation_System.Bus_Reservation.entity.Booking;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payment_id;
@Min(0) @Max(999999)
    private double ammount;

    private String payment_method;

    private  boolean payment_status;
@NotBlank
    private String transection_id;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
