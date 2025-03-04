package com.iguruu.ems.Mapper;

import com.iguruu.ems.Dto.DepartmentDto;
import com.iguruu.ems.Entity.Department;

public class DepartmentMapper {
	
	 public static DepartmentDto mapToDepartmentDto(Department department){
	        return new DepartmentDto(
	                department.getId(),
	                department.getDepartmentName(),
	                department.getDepartmentDescription()
	        );
	    }

	    // convert department dto into department jpa entity
	    public static Department mapToDepartment(DepartmentDto departmentDto){
	        return new Department(
	                departmentDto.getId(),
	                departmentDto.getDepartmentName(),
	                departmentDto.getDepartmentDescription()
	        );
	    }

}