package com.example.employeeapplication.service;

import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findByEmployeeId(id);
    }

    public Employee createEmployees(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeById(Employee employee, String employeeId) {
        Employee employeeFromDB = employeeRepository.findById(employeeId).orElse(null);
        if (employeeFromDB != null) {
            employeeFromDB.setEmployeeId(employee.getEmployeeId());
            employeeFromDB.setEmployeeName(employee.getEmployeeName());
            employeeFromDB.setSalary(employee.getSalary());
            employeeFromDB.setPosition(employee.getPosition());
            return employeeRepository.save(employeeFromDB);
        }
        return null;
    }

    public boolean deleteEmployeeById(String employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }
        else {
            return false;
        }
    }
}
