package com.it.repository.daosqlrepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface propertyrepo extends JpaRepository<Sqlentityproperty, Integer > {
	
	public Optional<Sqlentityproperty> findById(String id);
	

}
