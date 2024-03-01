package com.it.restapicontroller;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.it.controller.LoginDTO;
import com.it.controller.MessageDTO;
import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;
import com.it.security.JwtUtils;
import com.it.service.Validation;




@RestController
@RequestMapping("/api/v1")
public class ApiLoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils calljwtutils;
	
	@Autowired
	private SingupRepository callsignrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
//	@Autowired
//	private Validation callvaValidation;

	@PostMapping("/auth")
	public Map<String,Object>  postLogin(@RequestBody LoginDTO apilogin) {
		//authentication has two things - username and role
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(apilogin.getUsername(), apilogin.getPassword()));
		//it will come here only when username and password are correct!!
		String jwt = calljwtutils.generateJwtToken(authentication);
		Map<String,Object> jwtReponse = new HashMap<>();
		jwtReponse.put("Authorization", jwt);
		jwtReponse.put("username", apilogin.getUsername());		
		jwtReponse.put("title", "Manager");
		return jwtReponse;
	}
	
	
	//Http mapping
		@GetMapping("/alldata")
		public List<Mysqlentity> shoMysqlentities(){
			List<Mysqlentity> alldata=callsignrepo.findAll();	
			return alldata;
		}
	
	
		@PreAuthorize("hasAuthority('ADMIN')")
		@PostMapping("/pushdata")
		public MessageDTO postcall(@RequestBody Mysqlentity insertdata) {
			//taking data
			insertdata.setTimestamp(new Date());
//			insertdata.getEmail();
//			insertdata.getGender();
//			insertdata.getPassword();
//			insertdata.getDOB_day();
//			insertdata.getDOB_month();
//			insertdata.getDOB_year();
//			insertdata.getFirst_name();
//			insertdata.getLast_name();
			//query entity
			Optional<Mysqlentity> dbadd=callsignrepo.findById(insertdata.getUsername());
			//creating new instance
			MessageDTO messageout=new MessageDTO();				
		
			if(dbadd.isPresent()) {
				messageout.setMessage("Username aleady exists in system!");
				messageout.setCode(233);
			}else {
				 insertdata.setPassword(passwordEncoder.encode(insertdata.getPassword()));
				callsignrepo.save(insertdata);
				messageout.setMessage("You have done signup successfully!");
				messageout.setCode(200);		
			}
			
			return messageout;			
			
		}
		
		@PreAuthorize("hasAuthority('ADMIN')")
		@DeleteMapping("/deleteapi/{username}")
		public MessageDTO deletefromapi(@PathVariable String username) {
			callsignrepo.deleteById(username);
			
			
			MessageDTO messageout=new MessageDTO();		
			
			
			messageout.setMessage("Successfully Deleted!");
			messageout.setCode(917827);
				return messageout;
			
		}

	

}

