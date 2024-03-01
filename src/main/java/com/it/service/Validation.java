package com.it.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;


@Service
public class Validation {
	
	@Autowired
	private SingupRepository checkrepo;
	
	
	/*this is for static validation
	 * public boolean ConditionTrueFalse(String username, String password) {
		if("pema".equals(username) && "tamang".equals(password)) {
			return true;
		}else {
			return false;
			
				
		}
		
		
	}*/
	
	//for Mysql validation style 1
	public boolean ConditionTrueFalse(String username, String password) {
		
		Optional<Mysqlentity> checkdata=checkrepo.findByUsernameAndPassword(username, password);
		return checkdata.isPresent();
		
		
		
		
	}
	
public boolean roleTrueFalse(String username, String password, String role) {
		
		Optional<Mysqlentity> checkdata=checkrepo.findByUsernameAndPasswordAndRole(username, password, role);
		return checkdata.isPresent();
		
		
		
		
	}


public boolean userid(String username) {
	
	Optional<Mysqlentity> checkdata=checkrepo.findById(username);
	return checkdata.isPresent();
	
	
	
}

public String rolecheck(String role) {
	Optional<Mysqlentity> rolecheck=checkrepo.findByRole(role);
	if("Admin".equals(rolecheck(role))) {
		

	}return "ADMIN";
	
}
	


	
		
	

			
				
		
		
		
	
	

}
