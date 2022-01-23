package com.springboot.employeepayroll.services;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Override
	public String helloMessage() {
		return "Hello Nikhil...!";
	}
}