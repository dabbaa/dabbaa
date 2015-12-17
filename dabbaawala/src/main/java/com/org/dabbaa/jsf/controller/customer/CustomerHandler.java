package com.org.dabbaa.jsf.controller.customer;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.org.dabbaa.dao.CustomerDao;
import com.org.dabbaa.model.Customer;

@Component
@Scope("request")
@ManagedBean(name="customerhandler")
public class CustomerHandler implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerHandler.class);
	
	@Autowired
    private CustomerDao dao;
	
	
	private Customer customer=new Customer();
	
	private List<Customer> customerList;
	
	
	public List<Customer> getCustomerList() {
		customerList=dao.getCustomerList();
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void save(){
		logger.info("Customer :" +customer.getFirstName());
		dao.saveNewCustomer(customer);
		
	}
}
