package com.tecsup.petclinic.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "owners")

public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String address;
	private String city;
	private String telephone;
	
	public Owner(int id, String last_name, String city) {
		super();
		this.id = id;
		this.lastName = last_name;
		this.city = city;
	}

	public Owner(String first_name, String last_name, String city) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
		this.city = city;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	public Owner(long id, String first_name, String last_name, String address, String city,
			String telephone) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner() {
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", telephone=" + telephone + "]";
	}

}
