package com.it.service;

import java.util.List;

import com.it.controller.DaoentityDTO;


public interface Daorepointerface {
	
	List<DaoentityDTO> findAll();

	void save(DaoentityDTO entityDTO);

	DaoentityDTO findById(String id);

}
