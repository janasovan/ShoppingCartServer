package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity		//specify that it is an entity...   **java class that mapped to a db table...
@Table(name="Product_Table")		//if table name and domain class name is same, then no need to specify name here...
@Component		//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context..
public class Product {
	
	/* declare the database column names for Product table... */
	
	@Id		//id is primary key 
	@Column(name = "Pro_Id")		//specify the column name in database...
	private String id;
	
	@Column(name = "Pro_Name")		//specify the column name in database...
	private String name;
	
	@Column(name="Pro_Desc")		//specify the column name in database... 
	private String description;
	
	@Column(name = "Pro_Price")		//specify the column name in database...
	private int price;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
