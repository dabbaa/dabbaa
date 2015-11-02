package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vendor database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="vendor")
@NamedQuery(name="Vendor.findAll", query="SELECT v FROM Vendor v")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VENDOR_ID", unique=true, nullable=false)
	private int vendorId;

	@Column(nullable=false, length=45)
	private String address;

	@Column(name="CONTACT_NO", nullable=false, length=12)
	private String contactNo;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(name="EMAIL_ID", length=45)
	private String emailId;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	@Column(nullable=false, length=45)
	private String name;

	@Column(name="UPDATED_BY", length=45)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<Issue> issues;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<Menu> menus;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="vendor", fetch=FetchType.EAGER)
	private List<Rate> rates;

	//bi-directional many-to-many association to Location
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="vendor_location"
		, joinColumns={
			@JoinColumn(name="VENDOR_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="LOCATION_ID", nullable=false)
			}
		)
	private List<Location> locations;

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

	public List<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(List<CustomizedOrder> customizedOrders) {
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

	public List<DailyOrder> getDailyOrders() {
		return this.dailyOrders;
	}

	public void setDailyOrders(List<DailyOrder> dailyOrders) {
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

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
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

	public List<Issue> getIssues() {
		return this.issues;
	}

	public void setIssues(List<Issue> issues) {
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

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
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

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
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

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}