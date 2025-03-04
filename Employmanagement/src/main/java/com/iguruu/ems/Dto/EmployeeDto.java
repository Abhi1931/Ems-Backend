package com.iguruu.ems.Dto;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;

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
    private String designation;

    // Full constructor
    public EmployeeDto(Long id, String firstName, String lastName, String email, String designation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.designation = designation;
    }

    // Default constructor
    public EmployeeDto() {
    }

    // Getters and setters remain the same as in your original code
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}