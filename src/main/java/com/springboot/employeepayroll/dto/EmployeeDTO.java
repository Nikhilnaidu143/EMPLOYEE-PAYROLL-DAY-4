package com.springboot.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeeDTO {

	/***
	 * UC-4.1:- Add Validation to Name Field so the REST call can be validated.
	 ***/

	@NotEmpty(message = "Name cannot be null..!")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name validation failed..!")
	public String employee_name;
	
	@NotEmpty(message = "Gender cannot be null..!")
	public String gender;

	@Min(value = 1000, message = "Salary must be greater than 1000.")
	public long salary;

	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate startDate;
	
	@NotEmpty(message = "Note cannot be null..!")
	public String note;
	
	@NotEmpty(message = "Profile Picture cannot be null..!")
	public String profilePic;

	@NotEmpty(message = "Departments cannot be null...!")
	public List<String> departments; // list of departments.
}
