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
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}
}