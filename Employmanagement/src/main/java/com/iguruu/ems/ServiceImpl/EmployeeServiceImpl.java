package com.iguruu.ems.ServiceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iguruu.ems.Dto.EmployeeDto;
import com.iguruu.ems.Entity.Employee;
import com.iguruu.ems.Mapper.EmployeeMapper;
import com.iguruu.ems.Repository.EmployeeRepository;
import com.iguruu.ems.ResourceNotFoundException.ResourceNotFoundException;
import com.iguruu.ems.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);

	}
	 @Override
	    public void deleteEmployee(Long employeeId) {

	        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
	                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
	        );

	        employeeRepository.deleteById(employeeId);
	    }
     
	 @Override
	 public List<EmployeeDto> searchEmployees(String keyword) {
	     // Find employees by first name or last name (case-insensitive)
		 List<Employee> employees = employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);

	     
	     // Map Employee entities to EmployeeDto objects
	     return employees.stream()
	         .map(EmployeeMapper::mapToEmployeeDto)
	         .collect(Collectors.toList());
	 }
	

}
