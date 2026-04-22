package com.busyatra.controller;

import com.busyatra.entity.Employee;
import com.busyatra.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
@RequiredArgsConstructor
public class UserController {

    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(
            @Valid @RequestBody Employee employee) {

        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Integer id) {

        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = employeeService.AllEmployee();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(
            @Valid @RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
