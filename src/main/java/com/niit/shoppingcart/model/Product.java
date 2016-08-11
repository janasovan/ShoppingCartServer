package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Product_Table")		//if table name and domain class name is same, then no need to specify name here...
@Component
public class Product {

	@Id		//specify id as primary key...
	@Column//(name = "PRO_ID")
	private String id;
	
	@Column//(name = "PRO_NAME")
	private String name;
	
	@Column//(name = "PRO_DESC")
	private String description;
	
	@Column//(name = "PRO_PRICE")
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
