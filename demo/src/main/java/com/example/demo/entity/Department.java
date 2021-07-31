package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Please add department name.")
	private String name;
	private String address;
	private String depCode;
	
	
	public Department() {
		
	}
	
	
	
	public Department(Long id, @NotBlank(message = "Please add department name.") String name, String address,
			String depCode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.depCode = depCode;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	
	

}
