package com.springboot.employeepayroll.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.dto.ResponseDTO;
import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.services.EmployeePayrollService;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

	/***
	 * UC-2:- Create a Rest Controller to demonstrate the various HTTP Methods.
	 * 
	 * ----> Introducing Services Layer in Employee Payroll App.
	 ***/

	@Autowired
	private EmployeePayrollService employeePayrollService;

	@GetMapping(value = { "", "/", "/home" })
	public ResponseEntity<ResponseDTO> sayHello() {
		String mssg = employeePayrollService.helloMessage();
		ResponseDTO responseDTO = new ResponseDTO("Get Call successfull.", mssg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseDTO> fetchAllEmployersData() {
		List<Employee> allEmpData = employeePayrollService.fetchAllData();
		ResponseDTO responseDTO = new ResponseDTO("Get All data Call successfull.", allEmpData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get employee deatils by using employee ID . ***/
	@GetMapping(value = "/get/{emp_id}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable String emp_id) {
		Employee employee = employeePayrollService.getEmployeeById(emp_id);
		ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successfull..!", employee);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Creating employee deatils in the database. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> getEmployee(@RequestBody EmployeeDTO employee) {
		Employee employeeData = employeePayrollService.createEmployee(employee);
		ResponseDTO responseDTO = new ResponseDTO("Post Call for employee successfull..!", employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Updating already existing employee details. ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeeByID(@RequestBody EmployeeDTO employee, @PathVariable String id) {
		Employee employeeData = employeePayrollService.updateEmployeeDetails(employee, id);
		ResponseDTO responseDTO = new ResponseDTO("Put Call for employee successfull..!", employeeData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Delete employee deatils by using employee ID. ***/
	@DeleteMapping(value = "/delete/{emp_id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable String emp_id) {
		String employee = employeePayrollService.deleteEmployeeFromDB(emp_id);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call for employee successfull..!", employee);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}