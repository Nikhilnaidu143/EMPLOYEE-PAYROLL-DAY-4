package com.springboot.employeepayroll.dto;

import lombok.Data;

public @Data class EmployeeDTO {
	private String employee_name;
	private String gender;
	private String department;
	private long salary;

	public EmployeeDTO(String employee_name, String gender, String department, long salary) {
		this.employee_name = employee_name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
	}
}
