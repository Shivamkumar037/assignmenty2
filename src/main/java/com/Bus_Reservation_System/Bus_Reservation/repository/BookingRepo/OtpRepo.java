package com.Bus_Reservation_System.Bus_Reservation.repository.BookingRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepo extends JpaRepository<Otp,Integer> {
}
