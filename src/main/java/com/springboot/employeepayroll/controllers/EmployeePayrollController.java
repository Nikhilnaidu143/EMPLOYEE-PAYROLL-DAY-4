package com.springboot.employeepayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.services.EmployeePayrollService;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

	/***
	 * UC-2:- Create a Rest Controller to demonstrate the various HTTP Methods.
	 ***/

	@Autowired
	private EmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String sayHello() {
		return employeePayrollService.helloMessage();
	}

	@RequestMapping(value = "/get/{emp_id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable String emp_id) {
		return employeePayrollService.getEmployeeById(emp_id);
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public Employee getEmployee(@RequestBody Employee employee) {
		return employeePayrollService.createEmployee(employee);
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeePayrollService.updateEmployeeDetails(employee);
	}
	
	@RequestMapping(value = "/delete/{emp_id}" , method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable String emp_id) {
		return employeePayrollService.deleteEmployeeFromDB(emp_id);
	}
}