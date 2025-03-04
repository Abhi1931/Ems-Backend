package com.iguruu.ems.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iguruu.ems.Dto.EmployeeDto;
import com.iguruu.ems.Entity.Employee;

@Service
public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto getEmployeeById(Long employeeId);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

	void deleteEmployee(Long employeeId) ;

	List<EmployeeDto> searchEmployees(String keyword);
		
		
	
}
