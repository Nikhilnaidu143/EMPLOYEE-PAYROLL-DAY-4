package com.springboot.employeepayroll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	/*** Autowired annotation is used for automatic dependency injection. ***/
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	public String helloMessage() {
		return "Hello Nikhil...!";
	}

	@Override
	public List<Employee> fetchAllData() {
		return (List<Employee>) employeePayrollRepository.findAll();
	}

	/*** get employee deatils by using employee ID . ***/
	@Override
	public Employee getEmployeeById(String employee_ID) {
		Optional<Employee> employee = employeePayrollRepository.findById(Long.parseLong(employee_ID));
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	/*** Creating employee deatils in the database. ***/
	@Override
	public Employee createEmployee(EmployeeDTO employee) {
		return employeePayrollRepository.save(new Employee(employee));
	}

	/*** Updating already existing employee details. ***/
	public Employee updateEmployeeDetails(EmployeeDTO employee, String id) {
		Optional<Employee> findEmployee = employeePayrollRepository.findById(Long.parseLong(id));
		if (findEmployee.isPresent()) {
			return employeePayrollRepository.save(new Employee(Long.parseLong(id), employee));
		} else {
			return null;
		}
	}

	/*** Delete employee deatils by using employee ID. ***/
	@Override
	public String deleteEmployeeFromDB(String emp_id) {
		Optional<Employee> employee = employeePayrollRepository.findById(Long.parseLong(emp_id));
		if (employee.isPresent()) {
			employeePayrollRepository.deleteById(Long.parseLong(emp_id));
			return "Deleted employee details successfully";
		} else {
			return "Employee is not there in database.";
		}
	}
}