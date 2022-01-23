package com.springboot.employeepayroll.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	@Override
	public String helloMessage() {
		return "Hello Nikhil...!";
	}

	@Override
	public Employee getEmployeeById(String employee_ID) {
		Optional<Employee> employee = employeePayrollRepository.findById(Long.parseLong(employee_ID));
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		return employeePayrollRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		Optional<Employee> employee_find = employeePayrollRepository.findById(employee.getEmployee_ID());
		if (employee_find.isPresent()) {
			return employeePayrollRepository.save(employee);
		}
		return null;
	}

	public String deleteEmployeeFromDB(String emp_id) {
		Optional<Employee> employee = employeePayrollRepository.findById(Long.parseLong(emp_id));
		if(employee.isPresent()) {
			employeePayrollRepository.deleteById(Long.parseLong(emp_id));
			return "Deleted employee details successfully";
		}
		else {
			return "Employee is not there in database.";
		}
	}

}