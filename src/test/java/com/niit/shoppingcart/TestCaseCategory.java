package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;
	
	
	//Initialize test case...
	@Before
	public void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
		
	}
	
	/*
	@Test
	public void categoryListTestCase(){
		
		List<Category> list = categoryDAO.list();
		int rowCount = list.size();
		
		assertEquals("Category List Test Case ", rowCount, 3);		
		
	}*/
	
	/*
	@Test
	public void catagoryAddTestCase(){
		
		category.setId("CTG004");
		category.setName("CTG_Name_004");
		category.setDescription("CTG_hksdfkhjskgklsdgf");
		
		boolean flag = categoryDAO.save(category);
		assertEquals(flag, true);
	}*/
	
	//*
	@Test
	public void categoryGetTestCase(){
		
		category = categoryDAO.get("CTG001");
		
		assertEquals("CTG_name_001", category.getName());
	
		System.out.println("perfect run...."+category.getName());
	}
	//*/
	

}
