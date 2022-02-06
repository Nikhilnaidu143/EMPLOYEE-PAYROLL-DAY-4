package com.springboot.employeepayroll.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.dto.ResponseDTO;
import com.springboot.employeepayroll.models.Email;
import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.services.EmployeePayrollService;
import com.springboot.employeepayroll.services.IMailService;
import com.springboot.employeepayroll.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payroll")
@Slf4j
public class EmployeePayrollController {

	/***
	 * UC-2:- Create a Rest Controller to demonstrate the various HTTP Methods.
	 * 
	 * ----> Introducing Services Layer in Employee Payroll App.
	 ***/

	@Autowired // Autowired annotation is used for automatic injection.
	private EmployeePayrollService employeePayrollService;

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private IMailService mailService;

	/*** Simple hello message for checking. ***/
	@GetMapping(value = { "", "/", "/home" })
	public ResponseEntity<ResponseDTO> sayHello(@RequestParam(value = "token") String token) {
		String mssg = employeePayrollService.helloMessage(token);
		ResponseDTO responseDTO = new ResponseDTO("Get Call successfull.", mssg, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get All employee details . ***/
	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseDTO> fetchAllEmployersData(@RequestParam(value = "token") String token) {
		List<Employee> allEmpData = employeePayrollService.fetchAllData(token);
		ResponseDTO responseDTO = new ResponseDTO("Get All data Call successfull.", allEmpData, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get employee details by using employee ID . ***/
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<ResponseDTO> getEmployee(@RequestParam(value = "token") String token, @PathVariable Long id) {
		Employee employee = employeePayrollService.getEmployeeById(token, id);
		ResponseDTO responseDTO = new ResponseDTO("Get Call for ID successfull..!", employee, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** get employee details by using department. ***/
	@GetMapping(value = "department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department,
			@RequestParam(value = "token") String token) {
		List<Employee> empData = employeePayrollService.getEmployeesByDepartment(department, token);
		ResponseDTO responseDTO = new ResponseDTO("Get By Department Call Successfull.", empData, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Creating employee details in the database. ***/
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseDTO> getEmployee(@Valid @RequestBody EmployeeDTO employee) {
		log.info("Employee DTO :- " + employee.toString()); // logging.
		Employee employeeData = employeePayrollService.createEmployee(employee);
		String token = tokenUtil.createToken(employeeData.getEmployee_id());

		Email email = new Email(employeeData.getEmail(), "nnikhil976@gmail.com", "Verification",
				"Hello " + employeeData.getEmployee_name() + " ====> " + mailService.getLink(token));
		mailService.send(email);
		ResponseDTO responseDTO = new ResponseDTO("Post Call for employee successfull..!", employeeData, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Updating already existing employee details. ***/
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateEmployeeByID(@Valid @RequestBody EmployeeDTO employee,
			@RequestParam(value = "token") String token, @PathVariable Long id) {
		Employee employeeData = employeePayrollService.updateEmployeeDetails(employee, token, id);
		ResponseDTO responseDTO = new ResponseDTO("Put Call for employee successfull..!", employeeData, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	/*** Delete employee details by using employee ID. ***/
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@RequestParam(value = "token") String token,
			@PathVariable Long id) {
		String employee = employeePayrollService.deleteEmployeeFromDB(token, id);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call for employee successfull..!", employee, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping(value = "verify/{token}")
	public ResponseEntity<ResponseDTO> verifyEmployee(@PathVariable String token) {
		Employee employee = employeePayrollService.EmployeeVerification(token);
		ResponseDTO responseDTO = new ResponseDTO("Verification for employee successfull..!", employee, token);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
}