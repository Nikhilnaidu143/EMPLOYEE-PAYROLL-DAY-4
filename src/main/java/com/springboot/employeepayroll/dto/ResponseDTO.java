package com.springboot.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/***
 * UC-3.1:- Use Lombok Library to auto generate getters and setters for the DTO.
 ***/
@AllArgsConstructor
public @Data class ResponseDTO {

	private String message;
	private Object data;
	private String token;
	
	/*** Parameterized constructor. ***/
	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

}
