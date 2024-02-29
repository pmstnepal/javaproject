package com.it.restapicontroller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.controller.MessageDTO;
import com.it.repository.signup.Mysqlentity;
import com.it.repository.signup.SingupRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private SingupRepository repocall;
	
	
	
	//Http mapping
	@GetMapping("/alldata")
	public List<Mysqlentity> shoMysqlentities(){
		List<Mysqlentity> alldata=repocall.findAll();	
		return alldata;
	}
	
	@PostMapping("/pushdata")
	public MessageDTO postcall(@RequestBody Mysqlentity insertdata) {
		//taking data
		insertdata.setTimestamp(new Date());
		insertdata.getEmail();
		insertdata.getGender();
		insertdata.getPassword();
		insertdata.getDOB_day();
		insertdata.getDOB_month();
		insertdata.getDOB_year();
		insertdata.getFirst_name();
		insertdata.getLast_name();
		//query entity
		Optional<Mysqlentity> dbadd=repocall.findById(insertdata.getUsername());
		//creating new instance
		MessageDTO messageout=new MessageDTO();				
	
		if(dbadd.isPresent()) {
			messageout.setMessage("Username aleady exists in system!");
			messageout.setCode(233);
		}else {
			repocall.save(insertdata);
			messageout.setMessage("You have done signup successfully!");
			messageout.setCode(200);		
		}
		
		return messageout;			
		
	}
	
	@DeleteMapping("/deleteapi/{username}")
	public MessageDTO deletefromapi(@PathVariable String username) {
		repocall.deleteById(username);
		
		
		MessageDTO messageout=new MessageDTO();		
		
		
		messageout.setMessage("Successfully Deleted!");
		messageout.setCode(200);
			return messageout;
		
	}
	

}
