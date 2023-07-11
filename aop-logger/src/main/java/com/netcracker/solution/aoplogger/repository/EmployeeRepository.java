package com.netcracker.solution.aoplogger.repository;

import com.netcracker.solution.aoplogger.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
