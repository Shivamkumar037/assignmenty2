package com.Bus_Reservation_System.Bus_Reservation.repository.Schrdule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.SeatAvailibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatAvailibilityRepo extends JpaRepository<SeatAvailibility,Integer> {
}
