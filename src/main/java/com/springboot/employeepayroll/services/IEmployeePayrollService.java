package com.springboot.employeepayroll.services;

import java.util.List;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.models.Employee;

public interface IEmployeePayrollService {
	/*** Declaring methods ***/
	public Employee getEmployeeById(String employee_ID);

	public Employee createEmployee(EmployeeDTO employee);

	public Employee updateEmployeeDetails(EmployeeDTO employee, String id);

	public String deleteEmployeeFromDB(String emp_id);

	public List<Employee> employeeData = null;

	public List<Employee> fetchAllData();
}