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
import javax.persistence.Table;

import com.springboot.employeepayroll.dto.EmployeeDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "employee_payroll")
public @Data class Employee {

	/*** UC-5.1:- Add remaining properties to the Payroll DTO and Model. ***/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private long employee_id;

	@Column(name = "name")
	private String employee_name;
	private String gender;
	private long salary;
	private LocalDate start_date;
	private String note;
	private String profile_pic;
	private String email;
	private boolean verification;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id")) // joining tables by using
	@Column(name = "department")
	private List<String> department;
	
	/*** Parameterized constructor. ***/
	public Employee(EmployeeDTO employeeDTO) {
		this.employee_name = employeeDTO.employee_name;
		this.gender = employeeDTO.gender;
		this.salary = employeeDTO.salary;
		this.start_date = employeeDTO.start_date;
		this.note = employeeDTO.note;
		this.profile_pic = employeeDTO.profile_pic;
		this.email = employeeDTO.email;
		this.verification = false;
		this.department = employeeDTO.department;
	}

	/** Parameterized constructor(Constructor Overloading). **/
	public Employee(long employee_id, EmployeeDTO employeeDTO) {
		this.employee_id = employee_id;
		this.employee_name = employeeDTO.employee_name;
		this.gender = employeeDTO.gender;
		this.salary = employeeDTO.salary;
		this.start_date = employeeDTO.start_date;
		this.note = employeeDTO.note;
		this.profile_pic = employeeDTO.profile_pic;
		this.email = employeeDTO.email;
		this.verification = false;
		this.department = employeeDTO.department;
	}
}
