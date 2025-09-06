package com.example.employeeapplication.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    private String id;
    @Indexed(unique = true)
    private String employeeId;
    @NonNull
    private String employeeName;
    @NonNull
    private String position;
    @NonNull
    private int salary;
}
