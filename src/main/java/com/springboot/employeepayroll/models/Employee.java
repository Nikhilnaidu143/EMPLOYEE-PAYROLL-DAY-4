package com.springboot.employeepayroll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springboot.employeepayroll.dto.EmployeeDTO;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employee_ID;
	private String employee_name;
	private String gender;
	private String department;
	private long salary;

	/** Default constructor **/
	public Employee() {

	}

	/** Parameterized constructor. **/
	public Employee(long employee_ID, EmployeeDTO employeeDTO) {
		this.employee_ID = employee_ID;
		this.employee_name = employeeDTO.getEmployee_name();
		this.gender = employeeDTO.getGender();
		this.department = employeeDTO.getDepartment();
		this.salary = employeeDTO.getSalary();
	}

	public long getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(long employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}
