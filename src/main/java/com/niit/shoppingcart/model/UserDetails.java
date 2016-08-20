package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Entity		//specify that it is an entity...   **java class that mapped to a db table...
@Table//(name="UserDetails_Table")		if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class UserDetails {
	
	/* declare the database column names for UserDetails table... */
	
	@Id		//id is primary key 
//	@Column(name = "User_Id")	specify the column name in database...
	private String id;
	
//	@Column(name = "User_Name")	specify the column name in database...
	private String name;
	
//	@Column(name = "User_password")	specify the column name in database...	
	private String password;
	
	@Email(message = "provide a valid email address")
	@Column(name = "mail")		//specify the column name in database...	
	private String email;
	
	@Column(name = "Contact")	//specify the column name in database...	
	private String phone;
	
//	@Column(name = "User_Address")	specify the column name in database...	
	private String address;
	
	/* getters/setters for all the fields taken... */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
			
}
