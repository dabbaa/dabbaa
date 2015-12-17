package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the daily_order database table.
 * 
 */
@Entity
@Table(name="daily_order")
@NamedQuery(name="DailyOrder.findAll", query="SELECT d FROM DailyOrder d")
public class DailyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DAILY_ORDER_ID")
	private int dailyOrderId;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private double rate;

	@Temporal(TemporalType.DATE)
	@Column(name="TIFFIN_DATE")
	private Date tiffinDate;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	@Column(name="VENDOR_RATE")
	private double vendorRate;

	//bi-directional many-to-one association to Vendor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VENDOR_ID")
	private Vendor vendor;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;

	//bi-directional many-to-one association to Scheme
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SCHEME_ID")
	private Scheme scheme;

	//bi-directional many-to-one association to TiffinType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TIFFIN_TYPE_ID")
	private TiffinType tiffinType;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	public DailyOrder() {
	}

	public int getDailyOrderId() {
		return this.dailyOrderId;
	}

	public void setDailyOrderId(int dailyOrderId) {
		this.dailyOrderId = dailyOrderId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getTiffinDate() {
		return this.tiffinDate;
	}

	public void setTiffinDate(Date tiffinDate) {
		this.tiffinDate = tiffinDate;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public double getVendorRate() {
		return this.vendorRate;
	}

	public void setVendorRate(double vendorRate) {
		this.vendorRate = vendorRate;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Scheme getScheme() {
		return this.scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public TiffinType getTiffinType() {
		return this.tiffinType;
	}

	public void setTiffinType(TiffinType tiffinType) {
		this.tiffinType = tiffinType;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}