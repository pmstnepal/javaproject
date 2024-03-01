package com.it.repository.signup;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="personalinfo")
public class Mysqlentity{
	
	@Id
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private Date timestamp;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String DOB_month;
	private int	DOB_day;
	private int DOB_year;
	@Column(columnDefinition="varchar(30) default 'USER'")
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Mysqlentity() {
		
	}

	public String getDOB_month() {
		return DOB_month;
	}
	public void setDOB_month(String dOB_month) {
		DOB_month = dOB_month;
	}
	public int getDOB_day() {
		return DOB_day;
	}
	public void setDOB_day(int dOB_day) {
		DOB_day = dOB_day;
	}
	public int getDOB_year() {
		return DOB_year;
	}
	public void setDOB_year(int dOB_year) {
		DOB_year = dOB_year;
	}	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	
	
	
	

}
