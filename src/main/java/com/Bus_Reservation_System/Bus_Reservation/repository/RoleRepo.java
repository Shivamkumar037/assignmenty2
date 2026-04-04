package com.Bus_Reservation_System.Bus_Reservation.repository;

import com.Bus_Reservation_System.Bus_Reservation.entity.Role;
import com.Bus_Reservation_System.Bus_Reservation.entity.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {


    boolean existsByRole(RoleType roleType);

    Role findByRole(RoleType string);
}
