package com.Bus_Reservation_System.Bus_Reservation.repository.sechedule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusScheduleRepo extends JpaRepository<BusSchedule,Integer> {
}
