package com.springboot.employeepayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.services.EmployeePayrollService;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

	/***
	 * UC-1:- Create a Employee Payroll Spring Project to cater to REST Request from
	 * Employee Payroll UI - Here we will reuse the Employee.
	 ***/

	@Autowired
	private EmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String sayHello() {
		return employeePayrollService.helloMessage();
	}

	@RequestMapping("/getEmp/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeePayrollService.getEmployeeById(id);
	}
}