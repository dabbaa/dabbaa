package com.org.dabbaa.jsf.controller.customer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.org.dabbaa.dao.CustomerDao;
import com.org.dabbaa.model.Customer;

@Qualifier("customer")
@Component
@Scope("request")
public class CustomerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private CustomerDao dao;
	
	private List<Customer> customerList;
	
	
	public List<Customer> getCustomerList() {
		customerList=dao.getCustomerList();
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
}
