package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the issue database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="issue")
@NamedQuery(name="Issue.findAll", query="SELECT i FROM Issue i")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ISSUE_ID", unique=true, nullable=false)
	private int issueId;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="IS_SOLVED")
	private byte isSolved;

	@Column(nullable=false, length=500)
	private String issue;

	@Column(name="UPDATED_BY", length=45)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID")
	private Vendor vendor;

	public Issue() {
	}

	public int getIssueId() {
		return this.issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
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

	public byte getIsSolved() {
		return this.isSolved;
	}

	public void setIsSolved(byte isSolved) {
		this.isSolved = isSolved;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
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

}