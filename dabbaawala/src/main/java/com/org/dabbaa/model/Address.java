package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID", unique=true, nullable=false)
	private int addressId;

	@Column(nullable=false, length=200)
	private String address;

	@Column(length=45)
	private String city;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	private int pincode;

	@Column(length=45)
	private String state;

	@Column(name="UPDATED_BY", length=45)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_ON")
	private Date updatedOn;

	//bi-directional many-to-many association to Customer
	@ManyToMany(mappedBy="addresses", fetch=FetchType.EAGER)
	private List<Customer> customers;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="address", fetch=FetchType.EAGER)
	private List<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="address", fetch=FetchType.EAGER)
	private List<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="address", fetch=FetchType.EAGER)
	private List<Location> locations;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(List<CustomizedOrder> customizedOrders) {
		this.customizedOrders = customizedOrders;
	}

	public CustomizedOrder addCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().add(customizedOrder);
		customizedOrder.setAddress(this);

		return customizedOrder;
	}

	public CustomizedOrder removeCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().remove(customizedOrder);
		customizedOrder.setAddress(null);

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
		dailyOrder.setAddress(this);

		return dailyOrder;
	}

	public DailyOrder removeDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().remove(dailyOrder);
		dailyOrder.setAddress(null);

		return dailyOrder;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setAddress(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setAddress(null);

		return location;
	}

}