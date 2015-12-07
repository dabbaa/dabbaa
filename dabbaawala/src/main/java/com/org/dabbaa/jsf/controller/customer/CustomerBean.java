package com.org.dabbaa.jsf.controller.customer;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.org.dabbaa.dao.CustomerDao;
import com.org.dabbaa.model.Customer;

@ManagedBean(name="customer")
public class CustomerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
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
