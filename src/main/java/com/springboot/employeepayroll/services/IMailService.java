package com.springboot.employeepayroll.services;

import com.springboot.employeepayroll.models.Email;

public interface IMailService {
	
	/*** Declaring methods. ***/
	
	public void send(Email email);
	
	public String getLink(String token);
}
