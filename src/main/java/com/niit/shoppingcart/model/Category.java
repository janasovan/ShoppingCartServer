package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table	//(name="Category")		if table name and domain class name is same, then no need to specify name here...
public class Category {
	/* id, name, description are the  fields of the table */
	
	@Id		//id is primary key 
	private String id;
	
	private String name;
	
	@Column(name="desc")
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
