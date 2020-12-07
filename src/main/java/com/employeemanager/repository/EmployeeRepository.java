package com.employeemanager.repository;

import com.employeemanager.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long > {



}
