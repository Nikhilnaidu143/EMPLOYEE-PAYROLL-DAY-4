package com.springboot.employeepayroll.exceptions;

/**
 * UC-4.3:- Ability to throw User Friendly Errors in case Address Book Id is not
 * found in Address Book App.
 **/

public class EmployeePayrollException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeePayrollException(String message) {
		super(message);
	}
}
