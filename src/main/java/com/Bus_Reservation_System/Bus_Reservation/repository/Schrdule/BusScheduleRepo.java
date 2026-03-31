package com.Bus_Reservation_System.Bus_Reservation.repository.Schrdule;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusScheduleRepo extends JpaRepository<BusSchedule,Integer> {

    Optional<BusSchedule> findByBus(Bus bus);

}
