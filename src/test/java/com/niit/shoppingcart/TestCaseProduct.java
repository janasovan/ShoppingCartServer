package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;


public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	//Initialize test case...
	@Before
	public void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");		
		
	}
	
	@Test
	public void productListTestCase(){
		List<Product> list = productDAO.list();
		int rowCount = list.size();
		
		assertEquals(3, rowCount);
		
	}
/*	
	@Test
	public void productAddTestCase(){
		product.setId("PRO003");
		product.setName("PRO_name_003");
		product.setDescription("This is product003 description...");
		product.setPrice(8000);
		
		boolean flag = productDAO.save(product);
		assertEquals(flag, true);
				
	}
*/
	@Test
	public void productGetTestCase(){
		product = productDAO.get("PRO001");
		assertEquals("PRO_name_001", product.getName());
		
		System.out.println("Perfect Match...");
	}
	
}
