package com.iguruu.ems.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,name = "department_name")
    private String departmentName;

    public Department() {
    	
    }
}
