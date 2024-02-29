package com.it.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.it.controller.DaoentityDTO;
import com.it.repository.daosqlrepo.Sqlentityproperty;

@Service
public class Daointerfaceimpliment implements Daorepointerface{
	
	@Autowired
	private com.it.repository.daosqlrepo.propertyrepo sqlrepoautowired;

	@Override
	public List<DaoentityDTO> findAll() {
		List<Sqlentityproperty> listfromsql =sqlrepoautowired.findAll();
		List<DaoentityDTO> listfromdaoentityDTO=new ArrayList<DaoentityDTO>();
		//Write logic to convert List<sqlentityproperty> into List<DaoentityDTO>
		for(Sqlentityproperty converttolistsql : listfromsql) {
			DaoentityDTO dtoinstance=new DaoentityDTO();
			//Copying whole object data
			BeanUtils.copyProperties(converttolistsql, dtoinstance);
			listfromdaoentityDTO.add(dtoinstance);
		}
		return listfromdaoentityDTO;
	}

	@Override
	public void save(DaoentityDTO entityDTO) {
		// TODO Auto-generated method stub
		Sqlentityproperty sqlinstance =new Sqlentityproperty();
		BeanUtils.copyProperties(entityDTO, sqlinstance);
		sqlrepoautowired.save(sqlinstance);
		
	}

	@Override
	public DaoentityDTO findById(String id) {
		
		Optional<Sqlentityproperty> optfromsqlidref=sqlrepoautowired.findById(id);
		DaoentityDTO dtoinstance=new DaoentityDTO();
		if(optfromsqlidref.isEmpty()) {
		  throw new EmptyResultDataAccessException("ID does not exist into the database.",0);			
		}
		BeanUtils.copyProperties(optfromsqlidref.get(), dtoinstance);
		return dtoinstance;
		
	}

}
