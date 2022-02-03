package com.springboot.employeepayroll.models;

import lombok.Data;

public @Data class Email {
	
	private String to;
	private String from;
	private String subject;
	private String body;
}
