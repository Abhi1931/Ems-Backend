package com.iguruu.ems.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iguruu.ems.Dto.EmployeeDto;
import com.iguruu.ems.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
	}


	    
	   


