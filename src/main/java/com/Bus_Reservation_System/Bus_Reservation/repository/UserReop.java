package com.Bus_Reservation_System.Bus_Reservation.repository;

import com.Bus_Reservation_System.Bus_Reservation.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserReop extends JpaRepository<User, Integer> {

   Optional<User> findByUsername(@NotBlank(message = "Username is required") String username);

    boolean existsByUsername(@NotBlank(message = "Username is required") String username);

}
