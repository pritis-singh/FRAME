package com.netcracker.solution.aoplogger.controller;

import com.netcracker.solution.aoplogger.annotation.Auditable;
import com.netcracker.solution.aoplogger.entity.Employee;
import com.netcracker.solution.aoplogger.exception.ResourceNotFoundException;
import com.netcracker.solution.aoplogger.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    @Auditable
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }


    @PostMapping("/employees")
    @Auditable
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

}
