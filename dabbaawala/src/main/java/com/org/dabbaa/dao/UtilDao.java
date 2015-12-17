package com.org.dabbaa.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.dabbaa.model.TiffinType;

@Repository
public class UtilDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public List<TiffinType> getTiffinTypes(){
		Session session= sessionFactory.openSession();
		List<TiffinType> list=session.createCriteria(TiffinType.class).list();
			for(TiffinType bo:list)
			Hibernate.initialize(bo);
			
			session.flush();
			session.close();
		return list;
	}

}
