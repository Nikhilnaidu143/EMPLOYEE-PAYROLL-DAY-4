package com.springboot.employeepayroll.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.employeepayroll.models.Employee;

/*** Creating interface which extends CrudRepository. ***/
public interface EmployeePayrollRepository extends CrudRepository<Employee, Long> {

}