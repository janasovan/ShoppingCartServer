package com.niit.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity		//	**java class that mapped to a db table...
@Component
public class Cart implements Serializable{
	
	private static final long serialVersionUID = 10L;
	
	/* declare the database column names for Category table... */
	
	@Id
	private String cartId;
	
	@NotBlank
	private String userId;
	
	private String productId;
	
	private String productName;
	
	private double grandTotal;
	
	private int countProducts;

	/* getters/setters for all the fields taken... */
	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCountProducts() {
		return countProducts;
	}

	public void setCountProducts(int countProducts) {
		this.countProducts = countProducts;
	}

	
}
