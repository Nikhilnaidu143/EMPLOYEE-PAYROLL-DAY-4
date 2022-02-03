package com.springboot.employeepayroll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employeepayroll.dto.EmployeeDTO;
import com.springboot.employeepayroll.exceptions.EmployeePayrollException;
import com.springboot.employeepayroll.models.Employee;
import com.springboot.employeepayroll.repository.EmployeePayrollRepository;
import com.springboot.employeepayroll.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	/*** Autowired annotation is used for automatic dependency injection. ***/
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private MailService mailService;
	
	private static final String MESSAGE = "User is not verified Employee...!";

	/*** Simple hello message to check. ***/
	@Override
	public String helloMessage(String token) {
		Long tokenId = tokenUtil.decodeToken(token);
		Optional<Employee> employeeByToken = employeePayrollRepository.findById(tokenId);
		if (!employeeByToken.get().isVerification()) {
			throw new EmployeePayrollException(MESSAGE);
		} else {
				return "Hello Nikhil...!";
		}
	}

	/*** Get All Employee Details. ***/
	@Override
	public List<Employee> fetchAllData(String token) {
		Long id = tokenUtil.decodeToken(token);
		Optional<Employee> findEmployee = employeePayrollRepository.findById(id);
		if (!findEmployee.get().isVerification()) {
			throw new EmployeePayrollException(MESSAGE);
		} else {
			if (!findEmployee.isPresent()) {
				throw new EmployeePayrollException("Token is not valid...!");
			} else {
				return (List<Employee>) employeePayrollRepository.findAll();
			}
		}
	}

	/*** get employee details by using employee ID. ***/
	@Override
	public Employee getEmployeeById(String token, Long id) {
		Long tokenId = tokenUtil.decodeToken(token); // decoding token and getting id.
		Optional<Employee> employeeByToken = employeePayrollRepository.findById(tokenId);
		if (!employeeByToken.get().isVerification()) {
			throw new EmployeePayrollException(MESSAGE);
		} else {
			if (employeeByToken.isPresent()) {
				return employeePayrollRepository.findById(id)
						.orElseThrow(() -> new EmployeePayrollException("ID not found...!"));
			} else {
				return null;
			}
		}
	}

	/*** Get employees details by using department. ***/
	@Override
	public List<Employee> getEmployeesByDepartment(String department, String token) {
		Long id = tokenUtil.decodeToken(token);
		Optional<Employee> findEmployee = employeePayrollRepository.findById(id);
		if (!findEmployee.get().isVerification()) {
			throw new EmployeePayrollException(MESSAGE);
		} else {
			if (!findEmployee.isPresent()) {
				throw new EmployeePayrollException("Token is not valid...!");
			} else {
				return employeePayrollRepository.findEmployeesByDepartment(department);
			}
		}
	}

	/*** Creating employee details in the database. ***/
	@Override
	public Employee createEmployee(EmployeeDTO employee) {
		return employeePayrollRepository.save(new Employee(employee));
	}

	/*** Updating already existing employee details. ***/
	@Override
	public Employee updateEmployeeDetails(EmployeeDTO employee, String token, Long id) {
		Long tokenId = tokenUtil.decodeToken(token);
		Optional<Employee> employeeByToken = employeePayrollRepository.findById(tokenId);

		if (!employeeByToken.get().isVerification()) {
			mailService.send(employeeByToken.get().getEmail(), "Update Verification", mailService.getLink(token));
			return null;
		} else {
			Optional<Employee> findEmployee = employeePayrollRepository.findById(id);
			if (!findEmployee.isPresent()) {
				log.error("OOPS! Id not found in the database...!");
				throw new EmployeePayrollException("ID not found...!");
			} else {
				return employeePayrollRepository.save(new Employee(id, employee));
			}
		}
	}

	/*** Delete employee deatils by using employee ID. ***/
	@Override
	public String deleteEmployeeFromDB(String token, Long id) {
		Long tokenId = tokenUtil.decodeToken(token);
		Optional<Employee> employee = employeePayrollRepository.findById(tokenId);
		if (!employee.get().isVerification()) {
			throw new EmployeePayrollException(MESSAGE);
		} else {
			Optional<Employee> findEmployeeById = employeePayrollRepository.findById(id);
			if (findEmployeeById.isPresent()) {
				employeePayrollRepository.deleteById(id);
				return "Deleted employee details successfully";
			} else {
				return "Employee is not there in database.";
			}
		}
	}

	/*** Verifying user. ***/
	@Override
	public Employee EmployeeVerification(String token) {
		Long tokenId = tokenUtil.decodeToken(token);
		Optional<Employee> employee = employeePayrollRepository.findById(tokenId);
		if (!employee.isPresent()) {
			throw new EmployeePayrollException("ID not found...!");
		} else {
			employee.get().setVerification(true);
			return employeePayrollRepository.save(employee.get());
		}
	}
}