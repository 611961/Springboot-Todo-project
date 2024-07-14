package com.mywebapp.webProject.loginController;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
	public boolean authenticate(String username,String password) {
		boolean isValidU = username.equalsIgnoreCase("Nitin Sharma");
		boolean isValidP= password.equals("1234");
		
		return isValidP && isValidU; 
		
	}
}
