package com.Bus_Reservation_System.Bus_Reservation.repository.BookingRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.Booking.Booking;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {

    List<Booking> findAllByBusschedule(BusSchedule busSchedule1);

}
