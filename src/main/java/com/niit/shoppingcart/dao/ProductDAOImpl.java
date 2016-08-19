package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@EnableTransactionManagement
@Repository(value = "productDAO")		//@Repository annotation is a specialization of the @Component annotation with similar use and functionality...
public class ProductDAOImpl implements ProductDAO{	
	
	//private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	@Autowired		//@Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished..
					//first we need to create a connection. 
	private SessionFactory sessionFactory;		//Create a session for making connection...  **ApplicationContextConfiguration.java
				
	public ProductDAOImpl() {	//defaullt constructor of ProductDAOImpl...
		super();
	}
		// getter/setter method for sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ProductDAOImpl(SessionFactory sessionFactory){		//create ProductDAOImpl construstor taking sessionfactory as parameter..
		this.sessionFactory = sessionFactory;
	}
	
	// Declare all CRUD Operations...
	
	@Transactional
	public boolean save(Product product){		//to save record if record does not exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().save(product);		
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean update(Product product){	//to update the record that exist..
		try {			//take it on try-catch block so that if current session fails to save or fails to return true then it could return false...
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean delete(Product product){	//to delete from product..
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Product get(String id){
		
			//we need to declare the name i.e. hql (hibernate query language) to get response from the query related to db..
		String hql = " from Product where id = " + "'"	+ id + "'";	//  select * from Product where id = '___'
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> list = query.list();
		
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}		
	}
	
	@Transactional
	public List<Product> list() {
		
		String hql = " from Product ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
		
}
