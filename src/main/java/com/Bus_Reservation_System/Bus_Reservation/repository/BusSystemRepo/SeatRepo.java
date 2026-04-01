package com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
