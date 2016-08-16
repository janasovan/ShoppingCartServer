package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;


public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;	//instance of ProductDAO created...
	
	@Autowired
	Product product;		//instance of Product created...
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	//Initialize test case...
	@Before
	public void init(){		//init is just a method to initialize the instances...
		
		context = new AnnotationConfigApplicationContext();		//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");		//scan base package of the application...
		context.refresh();		//referesh the application...
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");		
		
	}
	
	@Test
	public void productListTestCase(){		// list operation is used to check the list in database table...
		
		//List<Product> list = productDAO.list();
		//int rowCount = list.size();
		//assertEquals(3, rowCount);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(productDAO.list().size(), 4);
		
	}
	
	@Test
	public void productAddTestCase(){		// add operation is used to save/add data in database...
		
		product.setId("PRO005");
		product.setName("PRO_name_005");
		product.setDescription("This is product005 description...");
		product.setPrice(41500);
		
		//boolean flag = productDAO.save(product);
		//assertEquals(flag, true);		//instead of using these two lines we can use just a single line as follows...
		
		assertEquals(productDAO.save(product), true);
				
	}
	
	@Test
	public void productUpdateTestCase(){
		
		product.setId("PRO002");
		product.setName("PRO_name_002");
		product.setDescription("This is product002 description...");
		product.setPrice(11500);
		
		assertEquals(productDAO.update(product), true);
	}
	
	
	public void productDeleteTestCase(){
		
		product.setId("");
		
		assertEquals(productDAO.delete(product), true);
	}

	@Test
	public void productGetTestCase(){		// get operation is used to get/fetch data from database...
		
		//product = productDAO.get("PRO001");
		//assertEquals("PRO_name_001", product.getName());		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(productDAO.get("PRO001").getName(), "PRO_name_001");
		
		System.out.println("Perfect Match...");
	}
	
}
