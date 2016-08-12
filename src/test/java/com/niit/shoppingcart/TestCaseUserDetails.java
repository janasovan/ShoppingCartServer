package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;


public class TestCaseUserDetails {

	@Autowired
	UserDetailsDAO userDetailsDAO;			//instance of UserDetailsDAO created...
	
	@Autowired
	UserDetails userDetails;				//instance of UserDetails created...
	
	AnnotationConfigApplicationContext context;		//instance created successfully...
	
	//Initialize test case...
	@Before
	public void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails = (UserDetails) context.getBean("userDetails");		
		
	}
/*	
	@Test
	public void userDetailsListTestCase(){
		List<UserDetails> list = userDetailsDAO.list();
		int rowCount = list.size();
		
		assertEquals(3, rowCount);
		
	}
*/	
	@Test
	public void userDetailsAddTestCase(){		
		userDetails.setId("USER005");
		userDetails.setName("USER_name_005");
		userDetails.setPassword("pwd005");
		userDetails.setEmail("user005@niit.com");
		userDetails.setPhone("1234004321");
		userDetails.setAddress("Hydrabad");
		
		boolean flag = userDetailsDAO.save(userDetails);
		assertEquals(flag, true);
				
	}

	@Test
	public void userDetailsGetTestCase(){
		userDetails = userDetailsDAO.get("USER001");
		assertEquals("USER_name_001", userDetails.getName());
		
		System.out.println("Perfect Match...");
	}
	
}
