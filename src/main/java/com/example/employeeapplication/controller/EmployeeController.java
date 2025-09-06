package com.example.employeeapplication.controller;

import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employee = employeeService.getAllEmployees();
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employeeFromDB = employeeService.createEmployees(employee);
        if (employeeFromDB != null) {
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable String employeeId) {
     Employee employeeFromDB = employeeService.updateEmployeeById(employee,employeeId);
     if (employeeFromDB != null) {
         return new ResponseEntity<>(employeeFromDB, HttpStatus.OK);
     }
     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping({"/{employeeId}"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable String employeeId) {
        Employee employeeFromDB = employeeService.getEmployeeById(employeeId);
        boolean ans = employeeService.deleteEmployeeById(employeeId);
        if(ans) {
            return new ResponseEntity<>(employeeFromDB, HttpStatus.OK);
        }
        return new ResponseEntity<>(employeeFromDB, HttpStatus.NOT_FOUND);
    }
}
