package com.mywebapp.webProject.loginController;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.classic.Logger;
//type manualy authentication
import org.springframework.security.core.Authentication;

@Controller
@SessionAttributes("name") // means we are passing value to another jsp but we had to add this annotation everycontrolr
public class Welcome {
			
///	private Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	
//	@RequestMapping("login")
//    public String gotologin(@RequestParam String name,ModelMap model) {
//		model.put("name", name);
//		
//        return "login";
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcome(ModelMap model) {
		model.put("name",getLoggedInUsername());
		return "welcome";
	}

	private String getLoggedInUsername() {
	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null) {
	        return authentication.getName(); // Assuming the username is stored as the principal's name
	    }
	    return null; // Handle the case where the username is not available
	}
    
  }	
