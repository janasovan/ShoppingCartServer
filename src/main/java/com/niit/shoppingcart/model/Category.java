package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table	//(name="Category")		if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class Category {
	/* id, name, description are the  fields of the table */
	
	@Id		//id is primary key 
	private String id;
	
	//
	private String name;
	
	@Column(name="desc")	//if column_name from table and variable_name is same then no need to specify name here... 
	private String description;
	
		
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
	public String getDesccription() {
		return description;
	}
	public void setDesccription(String desccription) {
		this.description = desccription;
	}
}
