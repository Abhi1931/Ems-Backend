package com.iguruu.ems.Dto;

import com.iguruu.ems.Entity.Department;
import lombok.Data;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;

@Data
public class EmployeeDto {

    @Id
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String department;

    // Default constructor
    public EmployeeDto() {
    }

}