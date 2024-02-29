package com.it.restapicontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.controller.DaoentityDTO;
import com.it.service.Daorepointerface;

@RestController
@RequestMapping("/api/dao")

public class Daoapicontroller {
	
	@Autowired
	private Daorepointerface DaoRepocall;
	
	@PostMapping("/property")
	public Map<String,Object> adddata(@RequestBody DaoentityDTO datafromDTO){
		DaoRepocall.save(datafromDTO);
		return Map.of("code",200,"message","Record is created successfully");
	}
		
	@GetMapping("/property")
	public List<DaoentityDTO> getalldata(){
		return DaoRepocall.findAll();		 

	}
	
	@GetMapping("/property/{id}")
	public DaoentityDTO getdataById(@PathVariable String id){
		return DaoRepocall.findById(id);
	}

}
