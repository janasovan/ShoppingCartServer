package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@EnableTransactionManagement
@Repository(value = "userDetailsDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class UserDetailsDAOImpl implements UserDetailsDAO{	
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
					//first we need to create a connection. 
	private SessionFactory sessionFactory;		//Create a session for making connection...  **ApplicationContextConfiguration.java
				
	public UserDetailsDAOImpl() {		//defaullt constructor of UserDetailsDAOImpl...
		super();
	}
		// getter/setter method for sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDetailsDAOImpl(SessionFactory sessionFactory){		//create UserDetailsDAOImpl construstor taking sessionfactory as parameter..
		this.sessionFactory = sessionFactory;
	}
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(UserDetails userDetails){			//to save record if record does not exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().save(userDetails);		
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(UserDetails userDetails){			//to update the record that exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(UserDetails userDetails){			//to delete from userDetails..
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public UserDetails get(String id){
		
			//we need to declare the name i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from UserDetails where id = " + "'"	+ id + "'";	//  select * from UserDetails where id = '___'
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}		
	}
	
	@Transactional
	public List<UserDetails> list() {
		
		String hql = " from UserDetails ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
		
}
