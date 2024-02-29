package com.it.repository.daosqlrepo;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="propertydata")
public class Sqlentityproperty {
	
	private int id;
	private String username;
	private int vehicle;
	private int land;
	private int landandhouses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getVehicle() {
		return vehicle;
	}
	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}
	public int getLand() {
		return land;
	}
	public void setLand(int land) {
		this.land = land;
	}
	public int getLandandhouses() {
		return landandhouses;
	}
	public void setLandandhouses(int landandhouses) {
		this.landandhouses = landandhouses;
	}
	
	
	
	
	
	
	

}
