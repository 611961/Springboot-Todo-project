package com.mywebapp.webProject.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.web.servlet.error.ErrorController; // Import the ErrorController interface

@Controller
public class Sayhello implements ErrorController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayhello() {
        return "jai shree ram";
    }

  
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayhelloHtml() {
    	
    	StringBuffer sb =  new StringBuffer();
    	sb.append("<!DOCTYPE html>\n");
    	sb.append("<html>\n");
    	sb.append("<head>\n");
    	sb.append("<title>Title of the Page</title>\n");
    	sb.append("</head>\n");
    	sb.append("<body>\n");

    	// Append the content
    	sb.append("<h1>Welcome to my Page</h1>\n");
    	sb.append("<p>Rahul Loves Deepika</p>\n");

    	// Close the HTML structure
    	sb.append("</body>\n");
    	sb.append("</html>\n");
    	
        return sb.toString();
    }
    
    
    //JSP
    
    @RequestMapping("say-hello-jsp")
    public String sayhelloJsp() {
    	
        return "sayHello";
    }
}
