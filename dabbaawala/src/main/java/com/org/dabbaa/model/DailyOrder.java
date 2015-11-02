package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the daily_order database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="daily_order")
@NamedQuery(name="DailyOrder.findAll", query="SELECT d FROM DailyOrder d")
public class DailyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DAILY_ORDER_ID", unique=true, nullable=false)
	private Integer dailyOrderId;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(nullable=false)
	private double rate;

	@Temporal(TemporalType.DATE)
	@Column(name="TIFFIN_DATE", nullable=false)
	private Date tiffinDate;

	@Column(name="UPDATED_BY", length=45)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	@Column(name="VENDOR_RATE", nullable=false)
	private double vendorRate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID", nullable=false)
	private Vendor vendor;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to TiffinType
	@ManyToOne
	@JoinColumn(name="TIFFIN_TYPE_ID", nullable=false)
	private TiffinType tiffinType;

	//bi-directional many-to-one association to Scheme
	@ManyToOne
	@JoinColumn(name="SCHEME_ID")
	private Scheme scheme;

	public DailyOrder() {
	}

	public Integer getDailyOrderId() {
		return this.dailyOrderId;
	}

	public void setDailyOrderId(Integer dailyOrderId) {
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public TiffinType getTiffinType() {
		return this.tiffinType;
	}

	public void setTiffinType(TiffinType tiffinType) {
		this.tiffinType = tiffinType;
	}

	public Scheme getScheme() {
		return this.scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

}