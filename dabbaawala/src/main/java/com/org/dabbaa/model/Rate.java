package com.org.dabbaa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the rate database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="rate")
@NamedQuery(name="Rate.findAll", query="SELECT r FROM Rate r")
public class Rate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RATE_ID", unique=true, nullable=false)
	private int rateId;

	@Column(name="CREATED_BY", nullable=false, length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON", nullable=false)
	private Date createdOn;

	@Column(nullable=false, length=45)
	private String description;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	@Column(nullable=false)
	private double rate;

	@Column(name="VENDOR_RATE", nullable=false)
	private double vendorRate;

	//bi-directional many-to-one association to TiffinType
	@ManyToOne
	@JoinColumn(name="TIFFIN_TYPE_ID", nullable=false)
	private TiffinType tiffinType;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID", nullable=false)
	private Vendor vendor;

	public Rate() {
	}

	public int getRateId() {
		return this.rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public double getRate() {
		return this.rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getVendorRate() {
		return this.vendorRate;
	}

	public void setVendorRate(double vendorRate) {
		this.vendorRate = vendorRate;
	}

	public TiffinType getTiffinType() {
		return this.tiffinType;
	}

	public void setTiffinType(TiffinType tiffinType) {
		this.tiffinType = tiffinType;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}