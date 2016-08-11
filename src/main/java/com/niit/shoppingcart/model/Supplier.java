package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity		//specify that it is an entity...		**java class that mapped to a db table...
@Table(name="Supplier_Table")		//if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class Supplier {
	
	/* declare the database column names for Supplier table... */
	
	@Id		//specify that id is primary key...
	@Column		//(name = "SUP_ID")	specify the column name in database...
	private String id;
	
	@Column		//(name = "SUP_NAME")	specify the column name in database...
	private String name;
	
	@Column		//(name = "SUP_ADDRESS")	specify the column name in database...
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
