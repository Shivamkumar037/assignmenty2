package com.Bus_Reservation_System.Bus_Reservation;

import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import com.Bus_Reservation_System.Bus_Reservation.repository.RoleRepo;
import com.Bus_Reservation_System.Bus_Reservation.repository.UserReop;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusReservationApplication {
    private UserReop userReop;
    private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication.class, args);
	}


}
