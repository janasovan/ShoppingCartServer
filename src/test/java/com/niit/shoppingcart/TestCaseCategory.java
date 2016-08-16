package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;	//instance of CategoryDAO created...
	
	@Autowired
	Category category;		//instance of Category created...
	
	AnnotationConfigApplicationContext context;		//instance of AnnotationConfigApplicationContext created...
	
	
	//Initialize the instances...
	@Before
	public void init(){		//init is just a method to initialize the instances...
		
		context = new AnnotationConfigApplicationContext();		//object of AnnotationConfigApplicationContext created...
		context.scan("com.niit");		//scan base package of the application...
		context.refresh();		//referesh the application...
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");		//create object of CategoryDAO and typecast it...
		category = (Category) context.getBean("category");		//create object of Category and typecast it...	
		
	}
	

	@Test
	public void categoryListTestCase(){		// list operation is used to check the list in db table...
		
		//List<Category> list = categoryDAO.list();
		//int rowCount = list.size();
		//assertEquals("Category List Test Case ", rowCount, 3);		//instead of using these three lines we can use just a single line as follows...
		
		assertEquals(categoryDAO.list().size(), 3);
		
	}
	
	@Test
	public void catagoryAddTestCase(){		// save operation is used to save/add data in database...
		
		category.setId("CTG004");
		category.setName("CTG_Name_004");
		category.setDescription("CTG_hksdfkhjskgklsdgf");
		
		//boolean flag = categoryDAO.save(category);
		//assertEquals(flag, true);			//instead of using these two lines we can use just a single line as follows...
		
		assertEquals(categoryDAO.save(category), true);
		
	}
	
	@Test
	public void categoryUpdateTestCase(){		// update operation is used to update data in database...
		
		category.setId("CTG001");
		category.setName("CTG_name_001");
		category.setDescription("This is CTG001 modified");
		
		//boolean flag = categoryDAO.update(category);
		//assertEquals(flag, true);			//instead of using these two lines we can use just a single line as follows...
				
		assertEquals(categoryDAO.update(category), true);
	}
	
	
	public void categoryDeleteTestCase(){		// delete operation is used to delete data from database...
		
		category.setId("CTG001");
		
		//boolean flag = categoryDAO.delete(category);
		//assertEquals(flag, true);			//instead of using these two lines we can use just a single line as follows...
		
		assertEquals(categoryDAO.delete(category), true);
	}
	
	@Test
	public void categoryGetTestCase(){		// get operation is used to get/fetch data from database...
		
		//category = categoryDAO.get("CTG001");		
		//assertEquals("CTG_name_001", category.getName());		//instead of using these two lines we can use just a single line as follows...
		
		assertEquals("CTG_name_001", categoryDAO.get("CTG001").getName());
	
		System.out.println("perfect run....");		//this is just a printline statement and can be removed...
	}
	//*/
	

}
