package com.example.employeeapplication;

import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.repository.EmployeeRepository;
import com.example.employeeapplication.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void testGetAllEmployees() {
        Employee employee1 = new Employee();
        employee1.setEmployeeName("John");
        employee1.setSalary(50000);
        employee1.setPosition("Software Engineer");
        Employee employee2 = new Employee();
        employee2.setEmployeeName("Jane");
        employee2.setSalary(50000);
        employee2.setPosition("Engineer");
        List<Employee> employees = Arrays.asList(employee1, employee2);
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(employees.size(), result.size());
    }

}
