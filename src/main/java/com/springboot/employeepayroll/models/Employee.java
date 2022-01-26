package com.springboot.employeepayroll.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springboot.employeepayroll.dto.EmployeeDTO;

import lombok.Data;

@Entity
public @Data class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employee_ID;
	private String employee_name;
	private String gender;
	private String department;
	private long salary;

	/** Default constructor. **/
	public Employee() {
		
	}
	
	public Employee(EmployeeDTO employeeDTO) {
		this.employee_ID = employee_ID;
		this.employee_name = employeeDTO.getEmployee_name();
		this.gender = employeeDTO.getGender();
		this.department = employeeDTO.getDepartment();
		this.salary = employeeDTO.getSalary();
	}

	/** Parameterized constructor. **/
	public Employee(long employee_ID, EmployeeDTO employeeDTO) {
		this.employee_ID = employee_ID;
		this.employee_name = employeeDTO.getEmployee_name();
		this.gender = employeeDTO.getGender();
		this.department = employeeDTO.getDepartment();
		this.salary = employeeDTO.getSalary();
	}
}
