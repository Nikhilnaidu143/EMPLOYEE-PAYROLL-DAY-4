package com.springboot.employeepayroll.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeeDTO {

	/***
	 * UC-4.1:- Add Validation to Name Field so the REST call can be validated.
	 ***/

	/*** UC-5.2:- Ensure validations is done on the Payroll DTO. ***/
	
	@NotNull(message = "Name cannot be null...!")
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Name validation failed..!")
	public String employee_name;
	
	@NotNull(message = "Gender cannot be null..!")
	@Pattern(regexp = "male|female|Male|Female" , message = "Please enter either 'male' or 'female'...!")
	public String gender;

	@Min(value = 1000, message = "Salary must be greater than 1000.")
	@NotNull(message = "salary cannot be null...!")
	public long salary;

	@NotNull(message = "Start date cannot be null...!")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "Start date cannot be future date...!")
	public LocalDate start_date;
	
	@NotNull(message = "Note cannot be null..!")
	public String note;
	
	@NotNull(message = "Profile Picture cannot be null..!")
	public String profile_pic;

	@Email(regexp = "^[\\w+-]+(\\.[\\w+-]+)*@[\\w]+(\\.[\\w]+)?(?=(\\.[A-Za-z_]{2,3}$|\\.[a-zA-Z]{2,3}$)).*$" , message = "Email validation failed...!")
	public String email;
	
	@NotNull(message = "Department cannot be null...!")
	@NotEmpty(message = "Department cannot be empty...!")
	public List<String> department; // list of departments.
}
