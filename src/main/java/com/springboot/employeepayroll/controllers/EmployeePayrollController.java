package com.springboot.employeepayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping(value = { "", "/", "/home" })
	public String sayHello() {
		return employeePayrollService.helloMessage();
	}

	/*** get employee deatils by using employee ID . ***/
	@GetMapping(value = "/get/{emp_id}")
	public Employee getEmployee(@PathVariable String emp_id) {
		return employeePayrollService.getEmployeeById(emp_id);
	}

	/*** Creating employee deatils in the database. ***/
	@PostMapping(value = "/post")
	public Employee getEmployee(@RequestBody Employee employee) {
		return employeePayrollService.createEmployee(employee);
	}

	/*** Updating already existing employee details. ***/
	@PutMapping("/update")
	public Employee updateEmployeeByID(@RequestBody Employee employee) {
		return employeePayrollService.updateEmployeeDetails(employee);
	}

	/*** Delete employee deatils by using employee ID. ***/
	@DeleteMapping(value = "/delete/{emp_id}")
	public String deleteEmployee(@PathVariable String emp_id) {
		return employeePayrollService.deleteEmployeeFromDB(emp_id);
	}
}