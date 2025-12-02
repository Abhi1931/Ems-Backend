package com.iguruu.ems.ServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.iguruu.ems.Entity.Department;
import com.iguruu.ems.Entity.Departments;
import com.iguruu.ems.Repository.DepartmentRepository;
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
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {


        Department department = null;

        String incoming = employeeDto.getDepartment();
        if (incoming != null && !incoming.isBlank()) {
            String trimmed = incoming.trim();

            department = departmentRepository.findByDepartmentNameIgnoreCase(trimmed).orElse(null);

            if (department == null) {

                List<String> enumNames = Arrays.stream(Departments.values())
                        .map(Enum::name)
                        .toList();
                String upper = trimmed.toUpperCase();
                if (enumNames.contains(upper)) {

                    Department newDept = new Department();
                    newDept.setDepartmentName(upper);
                    department = departmentRepository.save(newDept);
                } else {

                    throw new ResourceNotFoundException("Department does not exist: " + incoming);
                }
            }
        }
        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

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
		return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
				.collect(Collectors.toList());
	}

    List<String> departments = Arrays.stream(Departments.values()).map(Enum::toString).toList();

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee is not exists with given id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        if (updatedEmployee.getDepartment() != null &&
                !updatedEmployee.getDepartment().isBlank()) {

            String deptName = updatedEmployee.getDepartment().trim().toUpperCase();
            List<String> validDepts = Arrays.stream(Departments.values())
                    .map(Enum::name)
                    .toList();
            Department department = departmentRepository
                    .findByDepartmentNameIgnoreCase(deptName)
                    .orElse(null);
            if (department == null && validDepts.contains(deptName)) {
                department = new Department();
                department.setDepartmentName(deptName);
                department = departmentRepository.save(department);
            }

            employee.setDepartment(department);
        }

        Employee updated = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updated);
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
		 List<Employee> employees = employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
	     return employees.stream()
	         .map(EmployeeMapper::mapToEmployeeDto)
	         .collect(Collectors.toList());
	 }
	

}
