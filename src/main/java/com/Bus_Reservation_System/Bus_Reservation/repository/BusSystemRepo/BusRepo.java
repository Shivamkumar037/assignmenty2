package com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepo extends JpaRepository<Bus,Integer> {


    Optional<Bus> findByBusNo(String upperCase);
}
