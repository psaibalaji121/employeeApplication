package com.example.employeeapplication.repository;

import com.example.employeeapplication.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeeId(String id);
}
