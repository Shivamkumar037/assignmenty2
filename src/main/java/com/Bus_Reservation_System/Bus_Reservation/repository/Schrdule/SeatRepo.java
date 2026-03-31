package com.Bus_Reservation_System.Bus_Reservation.repository.Schrdule;

import com.Bus_Reservation_System.Bus_Reservation.entity.Schedule.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Integer> {

    List<Seat> findAllByBus_BusId(Integer busId);

}
