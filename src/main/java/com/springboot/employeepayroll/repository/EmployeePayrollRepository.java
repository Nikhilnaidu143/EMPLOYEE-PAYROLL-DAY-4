package com.springboot.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.employeepayroll.models.Employee;

/*** Creating interface which extends JpaRepository. ***/
public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {

	/***
	 * UC-5.6 :- Ability to retrieve all the records of employee payroll pertaining
	 * to sales department.
	 ***/

	@Query(value = "SELECT * FROM employee_payroll,employee_department WHERE employee_id=id AND department=:department", nativeQuery = true)
	List<Employee> findEmployeesByDepartment(String department);
}