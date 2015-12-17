package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the vendor database table.
 * 
 */
@Entity
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VENDOR_ID")
	private int vendorId;

	private String address;

	@Column(name="CONTACT_NO")
	private String contactNo;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	private String name;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<Feedback> feedbacks;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<Issue> issues;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<Menu> menus;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	private Set<Rate> rates;

	//bi-directional many-to-many association to Location
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="vendor_location"
		, joinColumns={
			@JoinColumn(name="VENDOR_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="LOCATION_ID")
			}
		)
	private Set<Location> locations;

	public Vendor() {
	}

	public int getVendorId() {
		return this.vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(Set<CustomizedOrder> customizedOrders) {
		this.customizedOrders = customizedOrders;
	}

	public CustomizedOrder addCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().add(customizedOrder);
		customizedOrder.setVendor(this);

		return customizedOrder;
	}

	public CustomizedOrder removeCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().remove(customizedOrder);
		customizedOrder.setVendor(null);

		return customizedOrder;
	}

	public Set<DailyOrder> getDailyOrders() {
		return this.dailyOrders;
	}

	public void setDailyOrders(Set<DailyOrder> dailyOrders) {
		this.dailyOrders = dailyOrders;
	}

	public DailyOrder addDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().add(dailyOrder);
		dailyOrder.setVendor(this);

		return dailyOrder;
	}

	public DailyOrder removeDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().remove(dailyOrder);
		dailyOrder.setVendor(null);

		return dailyOrder;
	}

	public Set<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setVendor(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setVendor(null);

		return feedback;
	}

	public Set<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

	public Issue addIssue(Issue issue) {
		getIssues().add(issue);
		issue.setVendor(this);

		return issue;
	}

	public Issue removeIssue(Issue issue) {
		getIssues().remove(issue);
		issue.setVendor(null);

		return issue;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setVendor(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setVendor(null);

		return menus;
	}

	public Set<Rate> getRates() {
		return this.rates;
	}

	public void setRates(Set<Rate> rates) {
		this.rates = rates;
	}

	public Rate addRate(Rate rate) {
		getRates().add(rate);
		rate.setVendor(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setVendor(null);

		return rate;
	}

	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

}