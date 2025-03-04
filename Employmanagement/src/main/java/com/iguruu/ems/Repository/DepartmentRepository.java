package com.iguruu.ems.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iguruu.ems.Entity.Department;

public interface DepartmentRepository extends JpaRepository <Department, Long> {

}
