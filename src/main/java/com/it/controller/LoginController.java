package com.it.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;
import com.it.service.Validation;



@Controller
public class LoginController {
	
	@Autowired
	private Validation callvalidation;
	
	@Autowired
	private SingupRepository callrepo;
	
	@GetMapping({"/login", "/", "/home"})
	public String showpage() {
		return "WEB-INF/login";
	}
	@PostMapping("/login")
	public String postLogin(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password= request.getParameter("password");
		String role= request.getParameter("role");
		if(callvalidation.roleTrueFalse(username, password, role) && "Admin".equals(role)) {			
			request.setAttribute("meg", "ADMIN DASBOARD");
			request.setAttribute("ucmtopen", "<!--");
			request.setAttribute("ucmtclose", "-->");
						List<com.it.repository.signup.Mysqlentity> crosscheck=callrepo.findAll();
			request.setAttribute("crosscheck", crosscheck);
			return "WEB-INF/home";
						
		}
		else if(callvalidation.ConditionTrueFalse(username, password) && "User".equals(role)) {	
			request.setAttribute("meg", username + " USER");
			request.setAttribute("cmtopen", "<!--");
			request.setAttribute("cmtclose", "-->");
			List<Mysqlentity> crosscheck=callrepo.findByUsername(username);			
			request.setAttribute("crosscheck", crosscheck);
			return "WEB-INF/home";
			
			
		}
		request.setAttribute("message", "Invalid Username and Password!!!");
		return "WEB-INF/login";
	}
	
	

	

}

