package com.it.controller;

import java.util.Date;
//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;


@Controller
public class SignupController {
	
	@Autowired
	private SingupRepository signuprepowired;
	
//	@GetMapping("HOME")
//	public String showPage() {
//		return "WEB-INF/Index";
//	}
	@GetMapping("/signup")
	public String showpage() {
		return "WEB-INF/signup";
	}
	@PostMapping("/signup")
	public String x(@ModelAttribute Mysqlentity signup, Model model) {
	
		
//	Using HttpServlet Request 
//	public String postLogin(HttpServletRequest request) {
//		String username=request.getParameter("username");
//		String password= request.getParameter("password");
//		String email=request.getParameter("email");
//		String gender=request.getParameter("gender");
//		System.out.println("username = "+username);
//		System.out.println("password = "+password);
//		System.out.println("email = "+email);
//		System.out.println("gender = "+gender);
//		request.setAttribute("message","You have done signup successfully!");
		
		signup.setTimestamp(new Date());
		signuprepowired.save(signup);
		model.addAttribute("message","You have done signup successfully!");
		return "WEB-INF/login";		
	}
	

}

