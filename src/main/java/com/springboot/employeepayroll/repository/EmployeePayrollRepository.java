package com.springboot.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employeepayroll.models.Employee;

/*** Creating interface which extends JpaRepository. ***/
public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {

}