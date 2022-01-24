package com.springboot.employeepayroll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long employee_ID;
	public String employee_name;
	public String gender;
	public String department;
	public long salary;

	/** Default constructor **/
	public Employee() {

	}

	/** Parameterized constructor. **/
	public Employee(long employee_ID, String employee_name, String gender, String department, long salary) {
		this.employee_ID = employee_ID;
		this.employee_name = employee_name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
	}
}