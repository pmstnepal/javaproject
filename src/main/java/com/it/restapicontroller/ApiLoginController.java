package com.it.restapicontroller;



import java.util.HashMap;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.it.controller.LoginDTO;

import com.it.security.JwtUtils;
import com.it.service.Validation;




@RestController
@RequestMapping("/api")
public class ApiLoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils calljwtutils;
	
		
	@Autowired
	private Validation callvaValidation;

	@PostMapping("/login")
	public Map<String,Object>  postLogin(@RequestBody LoginDTO apilogin) {
		//authentication has two things - username and role
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(apilogin.getUsername(), apilogin.getPassword()));
		String jwt = calljwtutils.generateJwtToken(authentication);
		Map<String,Object> jwtReponse = new HashMap<>();
		jwtReponse.put("Authorization", jwt);
		jwtReponse.put("username", apilogin.getUsername());
		jwtReponse.put("role", apilogin.getRole());
		jwtReponse.put("title", "Manager");
		return jwtReponse;
	}
	
	

	

}

