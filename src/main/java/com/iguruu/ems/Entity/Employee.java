package com.iguruu.ems.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
	Long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(unique = true)
	private String email;
	
    @Enumerated(EnumType.STRING)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "department_name")
	private Department department;

	public Employee() {

	}
}
