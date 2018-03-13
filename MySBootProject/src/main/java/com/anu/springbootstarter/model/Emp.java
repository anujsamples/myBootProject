package com.anu.springbootstarter.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	

	private String firstname;
	
	private String lastname;
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Emp(String firstname, String lastname, Date dob) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + "]";
	}
	public Emp() {
		
		
	}
}
