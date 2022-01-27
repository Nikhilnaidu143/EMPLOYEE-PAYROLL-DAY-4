package com.springboot.employeepayroll.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.springboot.employeepayroll.dto.EmployeeDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public @Data class Employee {

	/*** UC-5.1:- Add remaining properties to the Payroll DTO and Model. ***/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_ID")
	private long employee_ID;

	@Column(name = "name")
	private String employee_name;
	private String gender;
	private long salary;
	private LocalDate startDate;
	private String note;
	private String profilePic;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id")) // joining tables by using
																							// ID.
	@Column(name = "departments")
	private List<String> departments;

	/*** Parameterized constructor. ***/
	public Employee(EmployeeDTO employeeDTO) {
		this.employee_name = employeeDTO.employee_name;
		this.gender = employeeDTO.gender;
		this.salary = employeeDTO.salary;
		this.startDate = employeeDTO.startDate;
		this.note = employeeDTO.note;
		this.profilePic = employeeDTO.profilePic;
		this.departments = employeeDTO.departments;
	}

	/** Parameterized constructor(Constructor Overloading). **/
	public Employee(long employee_ID, EmployeeDTO employeeDTO) {
		this.employee_ID = employee_ID;
		this.employee_name = employeeDTO.employee_name;
		this.gender = employeeDTO.gender;
		this.salary = employeeDTO.salary;
		this.startDate = employeeDTO.startDate;
		this.note = employeeDTO.note;
		this.profilePic = employeeDTO.profilePic;
		this.departments = employeeDTO.departments;
	}
}
