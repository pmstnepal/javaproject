package com.it.controller;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;
import com.it.service.Validation;

@Controller
public class QueryEditDeleteController {
	
	@Autowired
	private Validation callvalidation;
	
	
	private SingupRepository signuprepowired;

	private String sname;
	
	@GetMapping("/deleteSignup")
	public String delete(@RequestParam String uname, Model model) {
		signuprepowired.deleteById(uname);
		
		List<Mysqlentity> crosscheck=signuprepowired.findAll();
		model.addAttribute("crosscheck", crosscheck);
		model.addAttribute("meg", "ADMIN DASBOARD");
		model.addAttribute("ucmtopen", "<!--");
		model.addAttribute("ucmtclose", "-->");
		model.addAttribute("message","Successfully Deleted!");
			return "WEB-INF/home";
		
	}
	
	@GetMapping("/ueditSignup")
	public String uedit(@RequestParam String xname, Model model) {
		Optional<Mysqlentity> optional=signuprepowired.findById(xname);
		
		model.addAttribute("calldata", optional.get());		
		model.addAttribute("message","Update the information!");
		return "WEB-INF/usignup";	
		
	}
	
	@GetMapping("/editSignup")
	public String edit(@RequestParam String xname, Model model) {
		Optional<Mysqlentity> optional=signuprepowired.findById(xname);
		
		
		model.addAttribute("calldata", optional.get());		
		model.addAttribute("message","Update the information!");
		return "WEB-INF/esignup";	
		
	}
	
//	@PostMapping("/esignup")
//	public String x(@ModelAttribute Mysqlentity esignup, Model model) {
//	
//		
////	Using HttpServlet Request 
////	public String postLogin(HttpServletRequest request) {
////		String username=request.getParameter("username");
////		String password= request.getParameter("password");
////		String email=request.getParameter("email");
////		String gender=request.getParameter("gender");
////		System.out.println("username = "+username);
////		System.out.println("password = "+password);
////		System.out.println("email = "+email);
////		System.out.println("gender = "+gender);
////		request.setAttribute("message","You have done signup successfully!");
//		
//		
//		signuprepowired.save(esignup);
//		model.addAttribute("message","You have updated successfully!");
//		List<Mysqlentity> crosscheck=signuprepowired.findAll();
//		model.addAttribute("crosscheck", crosscheck);
//		return "WEB-INF/home";		
//	}
	
	

	@GetMapping("/sortByName")
	public String sortbyNam(@RequestParam String sortbyN, Model model) {
		List<Mysqlentity> checkdata=signuprepowired.findAll();
		if(sortbyN.equalsIgnoreCase("asc")) {
			model.addAttribute("sortbyN", "desc");
			model.addAttribute("meg", "ADMIN DASBOARD");
			model.addAttribute("ucmtopen", "<!--");
			model.addAttribute("ucmtclose", "-->");
			model.addAttribute("message","Sorting by Name desc!");
				Collections.sort(checkdata, new Dfirsnamesorting());
			}else {
				model.addAttribute("sortbyN", "asc");
				model.addAttribute("meg", "ADMIN DASBOARD");
				model.addAttribute("ucmtopen", "<!--");
				model.addAttribute("ucmtclose", "-->");
				model.addAttribute("message","Sorting by Name Asc!");
				Collections.sort(checkdata, new Afirsnamesorting());
			}
		
		model.addAttribute("crosscheck", checkdata);
		
			return "WEB-INF/home";
		}
	@GetMapping("/sortByUsername")
	public String sortbyUsername(@RequestParam String sortbyU, Model model) {
		List<Mysqlentity> checkdata=signuprepowired.findAll();
		if(sortbyU.equalsIgnoreCase("asc")) {
			model.addAttribute("sortbyU", "desc");
			model.addAttribute("meg", "ADMIN");
			model.addAttribute("ucmtopen", "<!--");
			model.addAttribute("ucmtclose", "-->");
			model.addAttribute("message","Sorting by Username desc!");
				Collections.sort(checkdata, new Dusernamesorting());
			}else {
				model.addAttribute("sortbyU", "asc");
				model.addAttribute("meg", "ADMIN DASBOARD");
				model.addAttribute("ucmtopen", "<!--");
				model.addAttribute("ucmtclose", "-->");
				model.addAttribute("message","Sorting by Username Asc!");
				Collections.sort(checkdata, new Ausernamesorting());
			}
		
		model.addAttribute("crosscheck", checkdata);
		
			return "WEB-INF/home";
		}
	
	
	
	///search
	@GetMapping("/search")
	
	@PostMapping("/search")
	public String search(HttpServletRequest request) {
		String username=request.getParameter("username");
		System.out.println(username);
		request.setAttribute("meg", "ADMIN DASBOARD");
		request.setAttribute("ucmtopen", "<!--");
		request.setAttribute("ucmtclose", "-->");
			List<Mysqlentity> crosscheck=signuprepowired.findByUsername(username);
			request.setAttribute("crosscheck", crosscheck);
			return "WEB-INF/home";	
		
	}
	
	
	@PostMapping("/usignup")
	public String upostSigup(@ModelAttribute Mysqlentity update, Model model) {
			
			Mysqlentity dbadd=signuprepowired.findById(update.getUsername()).get();
			dbadd.setEmail(update.getEmail());
			dbadd.setGender(update.getGender());
			dbadd.setPassword(update.getPassword());
			dbadd.setDOB_day(update.getDOB_day());
			dbadd.setDOB_month(update.getDOB_month());
			dbadd.setDOB_year(update.getDOB_year());
			dbadd.setFirst_name(update.getFirst_name());
			dbadd.setLast_name(update.getLast_name());
			
			signuprepowired.save(dbadd);
			model.addAttribute("message","You have updated signup successfully!");
			//Fetch remaining data from data
			

			model.addAttribute("meg", update.getUsername() + " USER");
			model.addAttribute("cmtopen", "<!--");
			model.addAttribute("cmtclose", "-->");
			List<Mysqlentity> crosscheck=signuprepowired.findByUsername(update.getUsername());			
			model.addAttribute("crosscheck", crosscheck);
			return "WEB-INF/home";
			}
			@PostMapping("/esignup")
			public String epostSigup(@ModelAttribute Mysqlentity update, Model model) {
					
					Mysqlentity dbadd=signuprepowired.findById(update.getUsername()).get();
					dbadd.setEmail(update.getEmail());
					dbadd.setGender(update.getGender());
					dbadd.setPassword(update.getPassword());
					dbadd.setDOB_day(update.getDOB_day());
					dbadd.setDOB_month(update.getDOB_month());
					dbadd.setDOB_year(update.getDOB_year());
					dbadd.setFirst_name(update.getFirst_name());
					dbadd.setLast_name(update.getLast_name());
					
					signuprepowired.save(dbadd);
					model.addAttribute("message","You have updated signup successfully!");
					//Fetch remaining data from data
					
//					if("User".equals(dbadd.getRole())) {
					model.addAttribute("meg", "ADMIN DASBOARD");		
					model.addAttribute("ucmtopen", "<!--");
					model.addAttribute("ucmtclose", "-->");
					List<Mysqlentity> crosscheck=signuprepowired.findAll();			
					model.addAttribute("crosscheck", crosscheck);
					return "WEB-INF/home";
//					}
//					else if ("Admin".equals(dbadd.getRole())) {
//						model.addAttribute("meg", "ADMIN DASHBOARD");
//						List<Mysqlentity> crosscheck=signuprepowired.findAll();
//						return "WEB-INF/home";
//						
//					}
		}

		
			

	
			
	
}
		
	
	
	

