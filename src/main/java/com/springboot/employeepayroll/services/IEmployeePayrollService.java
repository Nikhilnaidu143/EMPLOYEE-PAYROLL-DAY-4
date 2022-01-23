package com.springboot.employeepayroll.services;

import com.springboot.employeepayroll.models.Employee;

public interface IEmployeePayrollService {
	
	public String helloMessage();
	public Employee getEmployeeById(String employee_ID);
	public Employee createEmployee(Employee employee);
	public Employee updateEmployeeDetails(Employee employee);
	public String deleteEmployeeFromDB(String emp_id);
}