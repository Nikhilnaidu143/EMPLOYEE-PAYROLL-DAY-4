package com.springboot.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class EmployeeDTO {

	/***
	 * UC-4.1:- Add Validation to Name Field so the REST call can be validated.
	 ***/

	@NotEmpty
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name validation failed..!")
	private String employee_name;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String department;
	@Min(value = 1000, message = "Salary must be greater than 1000.")
	private long salary;

	public EmployeeDTO(String employee_name, String gender, String department, long salary) {
		this.employee_name = employee_name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
	}
}
