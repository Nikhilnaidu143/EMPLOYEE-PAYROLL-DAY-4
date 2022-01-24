package com.springboot.employeepayroll.dto;

public class EmployeeDTO {
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
