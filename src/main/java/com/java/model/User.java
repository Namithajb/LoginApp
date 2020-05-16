package com.java.model;




import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotEmpty(message = "Name is mandatory")
	private String username;
	
	@NotEmpty(message = "Password is mandatory")
	@Size(min=1,message="required") 
	private String password;
	
	@NotEmpty(message = "Firstname is mandatory")
	private String firstname;
	
	@NotEmpty(message = "Lastname is mandatory")
	private String lastname;
	
	@NotEmpty(message = "Email is mandatory")
	@Email
	private String email;
	
	@NotEmpty(message = "Address is mandatory")
	private String address;
	
	
	private int phone;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String firstname, String lastname, String email, String address, int phone) {
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.address=address;
		this.phone=phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}