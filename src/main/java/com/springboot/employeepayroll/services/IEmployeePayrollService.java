package com.springboot.employeepayroll.services;

import java.util.List;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.models.Employee;

public interface IEmployeePayrollService {
	/*** Declaring methods ***/
	public String helloMessage(String token);
	
	public List<Employee> employeeData = null;

	public List<Employee> fetchAllData(String token);
	
	public Employee getEmployeeById(String token, Long id);
	
	public List<Employee> getEmployeesByDepartment(String department , String token);

	public Employee createEmployee(EmployeeDTO employee);

	public Employee updateEmployeeDetails(EmployeeDTO employee, String token, Long id);

	public String deleteEmployeeFromDB(String token , Long id);

}