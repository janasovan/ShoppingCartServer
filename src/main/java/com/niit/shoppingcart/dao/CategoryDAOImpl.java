package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;


@EnableTransactionManagement
@Repository(value = "categoryDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class CategoryDAOImpl implements CategoryDAO{	
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
					//first we need to create a connection. 
	private SessionFactory sessionFactory;		//Create a session for making connection...  **ApplicationContextConfiguration.java
	
	public CategoryDAOImpl() {		//defaullt constructor of CategoryDAOImpl...
		super();
	}
	
		// getter/setter method for sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CategoryDAOImpl(SessionFactory sessionFactory){		//create CategoryDAOImpl construstor taking sessionfactory as parameter..
		this.sessionFactory = sessionFactory;
	}
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(Category category){		//to save record if record does not exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().save(category);		
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Category category){	//to update the record that exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(Category category){	//to delete from category..
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Category get(String id){
		
			//we need to declare the name i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from Category where id = " + "'"	+ id + "'";	//  select * from Category where id = '___'
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}		
	}
	
	@Transactional
	public List<Category> list() {
		
		String hql = " from Category ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
		
}
