package com.Bus_Reservation_System.Bus_Reservation.repository.BusSystemRepo;

import com.Bus_Reservation_System.Bus_Reservation.entity.BusSystem.Bus;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepo extends JpaRepository<Bus,Integer> {

    boolean existsByBusNumber(@NotBlank String busNumber);

    boolean existsByBusid(@NotBlank String busNumber);

}
