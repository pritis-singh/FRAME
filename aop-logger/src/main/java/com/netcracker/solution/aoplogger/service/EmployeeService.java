package com.netcracker.solution.aoplogger.service;

import com.netcracker.solution.aoplogger.entity.Employee;
import com.netcracker.solution.aoplogger.exception.ResourceNotFoundException;
import com.netcracker.solution.aoplogger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
