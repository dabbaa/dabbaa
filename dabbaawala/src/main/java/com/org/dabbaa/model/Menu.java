package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MENU_ID", unique=true, nullable=false)
	private int menuId;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(nullable=false, length=500)
	private String description;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="VENDOR_ID", nullable=false)
	private Vendor vendor;

	//bi-directional many-to-one association to TiffinType
	@ManyToOne
	@JoinColumn(name="TIFFIN_TYPE_ID", nullable=false)
	private TiffinType tiffinType;

	public Menu() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public TiffinType getTiffinType() {
		return this.tiffinType;
	}

	public void setTiffinType(TiffinType tiffinType) {
		this.tiffinType = tiffinType;
	}

}