package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID", unique=true, nullable=false)
	private int customerId;

	@Column(name="`COMMENT`", length=100)
	private String comment;

	@Column(name="CONTACT_NO", nullable=false, length=12)
	private String contactNo;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="EMAIL_ID", length=45)
	private String emailId;

	@Column(name="FIRST_NAME", nullable=false, length=45)
	private String firstName;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	@Column(name="LAST_NAME", length=45)
	private String lastName;

	@Column(name="UPDATED_BY", length=45)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-many association to Address
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="customer_address"
		, joinColumns={
			@JoinColumn(name="CUSTOMER_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ADDRESS_ID", nullable=false)
			}
		)
	private List<Address> addresses;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private List<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private List<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private List<Issue> issues;

	public Customer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(List<CustomizedOrder> customizedOrders) {
		this.customizedOrders = customizedOrders;
	}

	public CustomizedOrder addCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().add(customizedOrder);
		customizedOrder.setCustomer(this);

		return customizedOrder;
	}

	public CustomizedOrder removeCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().remove(customizedOrder);
		customizedOrder.setCustomer(null);

		return customizedOrder;
	}

	public List<DailyOrder> getDailyOrders() {
		return this.dailyOrders;
	}

	public void setDailyOrders(List<DailyOrder> dailyOrders) {
		this.dailyOrders = dailyOrders;
	}

	public DailyOrder addDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().add(dailyOrder);
		dailyOrder.setCustomer(this);

		return dailyOrder;
	}

	public DailyOrder removeDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().remove(dailyOrder);
		dailyOrder.setCustomer(null);

		return dailyOrder;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setCustomer(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setCustomer(null);

		return feedback;
	}

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setCustomer(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setCustomer(null);

		return issue;
	}

}