package com.busyatra.service.type;



import com.busyatra.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee findById(Integer id );
    Employee deleteEmployee(Integer id);
    Employee updateEmployee(Employee employee);
    Employee createEmployee(Employee employee);
    List<Employee> AllEmployee();


}
