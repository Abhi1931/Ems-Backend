package com.iguruu.ems.Mapper;

import com.iguruu.ems.Dto.EmployeeDto;
import com.iguruu.ems.Entity.Department;
import com.iguruu.ems.Entity.Departments;
import com.iguruu.ems.Entity.Employee;

import java.util.Arrays;
import java.util.List;


public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartment(employee.getDepartment().getDepartmentName());
        return employeeDto;
    }

}