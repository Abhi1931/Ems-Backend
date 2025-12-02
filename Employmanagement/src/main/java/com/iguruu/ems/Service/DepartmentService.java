package com.iguruu.ems.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iguruu.ems.Dto.DepartmentDto;

@Service
public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	DepartmentDto getDepartmentById(Long departmentId);
	List<DepartmentDto> getAllDepartments();
	DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);
	void deleteDepartment(Long departmentId);
	
}
