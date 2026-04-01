package com.Bus_Reservation_System.Bus_Reservation.entity;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.CancleBooking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Otp;
import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3,max = 20,message = "Name can not be Lessthen 3 or grater 20")
    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 10,max = 16)
    private String phone;

    @NotBlank
    private String  password;
    private boolean status = true;
    private LocalDate dob;
    private boolean isActive=false;
    private boolean isVerified;
    private String aadhar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
@OneToMany(mappedBy = "drivar")
List<Bus> driverList;

    @OneToMany(mappedBy = "user")
    List<Booking> bookings;

    @OneToMany(mappedBy = "conductor")
    List<Bus> conductorList;
    @OneToMany(mappedBy = "user")
    List<Otp> otps;
    @OneToMany(mappedBy = "user")
    List<CancleBooking> cancleBookings;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
