package com.example.employeeapplication;

import com.example.employeeapplication.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @Test
    void testGetAllEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setEmployeeName("James");
        employee.setSalary(5000);
        employee.setPosition("Software Engineer");
        Employee employee2 = new Employee();
        employee2.setEmployeeName("Bob");
        employee2.setSalary(5000);
        employee2.setPosition("Software Engineer");
        List<Employee> employees = Arrays.asList(employee, employee2);


        mockMvc.perform(MockMvcRequestBuilders.get("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(employees)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testCreateEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setEmployeeId("E101");
        emp.setEmployeeName("Alice");
        emp.setPosition("Tester");
        emp.setSalary(5000);

        mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(emp)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeName").value("Alice"));
    }
}
