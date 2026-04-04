package com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepo extends JpaRepository<Stop,Integer> {
    List<Stop> findAllByRouteid(Integer id);
}
