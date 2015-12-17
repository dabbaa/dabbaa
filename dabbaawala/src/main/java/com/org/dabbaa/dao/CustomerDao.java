package com.org.dabbaa.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dabbaa.model.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public List<Customer> getCustomerList(){
		Session session= sessionFactory.openSession();
		List<Customer> list=session.createCriteria(Customer.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}



	public void saveNewCustomer(Customer customer) {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.flush();
	}

}
