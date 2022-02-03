package com.springboot.employeepayroll.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.springboot.employeepayroll.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

	/***
	 * UC-4.2:- Provide User Friendly Error Response in case validation fails.
	 ***/

	private static final String MESSAGE = "Exception while procession REST request.";

	/*** handling exceptions when validation failed. ***/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMssg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errorMssg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/*** Handling exception when id not found in the database. ***/
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleAddressBookException(EmployeePayrollException exception) {
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/*** Handling exception when date format is incorrect. ***/
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid date format :- ", exception.getMessage());
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, "Date should be in (yyyy-MM-dd) this format...!");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	/*** Handling exception when token is not valid. ***/
	@ExceptionHandler(SignatureVerificationException.class)
	public ResponseEntity<ResponseDTO> handleSignatureVerificationException(SignatureVerificationException exception) {
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.UNAUTHORIZED);
	}
}
