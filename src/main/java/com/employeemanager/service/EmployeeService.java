package com.employeemanager.service;

import com.employeemanager.Employee;
import com.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> listAll(){
        return repo.findAll();
    }

    public void save(Employee employee){
        repo.save(employee);
    }

    public Employee get (Long id){
        return repo.findById(id).get();
    }

    public void delete (Long id){
        repo.deleteById(id);
    }
}
