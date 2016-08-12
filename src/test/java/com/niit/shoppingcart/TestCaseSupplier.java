package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;


public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	//Initialize test case...
	@Before
	public void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");		
		
	}
	
	@Test
	public void supplierListTestCase(){
		List<Supplier> list = supplierDAO.list();
		int rowCount = list.size();
		
		assertEquals(4, rowCount);
		
	}
/*	
	@Test
	public void supplierAddTestCase(){
		supplier.setId("SUP004");
		supplier.setName("Pantaloons");
		supplier.setAddress("Kolkata");
		
		boolean flag = supplierDAO.save(supplier);
		assertEquals(flag, true);
				
	}
*/
	@Test
	public void supplierGetTestCase(){
		supplier = supplierDAO.get("SUP001");
		assertEquals("Reliance Trendz", supplier.getName());
		
		System.out.println("Perfect Match...");
	}
	
}
