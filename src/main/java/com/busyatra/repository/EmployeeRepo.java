package com.busyatra.repository;

import com.busyatra.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(Integer id);

   Optional< Employee> findByEmail(String email);
}
