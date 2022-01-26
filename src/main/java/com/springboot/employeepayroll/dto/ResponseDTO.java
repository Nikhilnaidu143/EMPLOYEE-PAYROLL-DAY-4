package com.springboot.employeepayroll.dto;

import lombok.Data;

/***
 * UC-3.1:- Use Lombok Library to auto generate getters and setters for the DTO.
 ***/
public @Data class ResponseDTO {

	private String message;
	private Object data;

	public ResponseDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}
}
