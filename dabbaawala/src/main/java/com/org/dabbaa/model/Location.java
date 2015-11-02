package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOCATION_ID", unique=true, nullable=false)
	private int locationId;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(nullable=false, length=45)
	private String description;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private Address address;

	//bi-directional many-to-many association to Vendor
	@ManyToMany(mappedBy="locations", fetch=FetchType.EAGER)
	private List<Vendor> vendors;

	public Location() {
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Vendor> getVendors() {
		return this.vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

}