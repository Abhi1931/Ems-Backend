package com.iguruu.ems.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DepartmentDto {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "department_name")
	    private String departmentName;

	    @Column(name = "department_description")
	    private String departmentDescription;

	    public DepartmentDto() {
	    	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getDepartmentDescription() {
			return departmentDescription;
		}

		public void setDepartmentDescription(String departmentDescription) {
			this.departmentDescription = departmentDescription;
		}

		public DepartmentDto(Long id, String departmentName, String departmentDescription) {
			super();
			this.id = id;
			this.departmentName = departmentName;
			this.departmentDescription = departmentDescription;
		}
	    
	
}
