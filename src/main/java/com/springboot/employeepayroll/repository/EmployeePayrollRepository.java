package com.springboot.employeepayroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.employeepayroll.models.Employee;

public interface EmployeePayrollRepository extends CrudRepository<Employee, Long>{

}