package com.springboot.employeepayroll.services;

public interface IMailService {
	
	/*** Declaring methods. ***/
	public void send(String toEmail, String subject, String body);
	
	public String getLink(String token);
}
