package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the scheme database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="scheme")
@NamedQuery(name="Scheme.findAll", query="SELECT s FROM Scheme s")
public class Scheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCHEME_ID", unique=true, nullable=false)
	private int schemeId;

	@Column(name="CREATED_BY", length=45)
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	private Date createdOn;

	@Column(nullable=false, length=45)
	private String description;

	private double discount;

	@Column(name="EXTRA_COST")
	private double extraCost;

	@Column(name="IS_ACTIVE")
	private byte isActive;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="scheme", fetch=FetchType.EAGER)
	private List<DailyOrder> dailyOrders;

	public Scheme() {
	}

	public int getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
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

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getExtraCost() {
		return this.extraCost;
	}

	public void setExtraCost(double extraCost) {
		this.extraCost = extraCost;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public List<DailyOrder> getDailyOrders() {
		return this.dailyOrders;
	}

	public void setDailyOrders(List<DailyOrder> dailyOrders) {
		this.dailyOrders = dailyOrders;
	}

	public DailyOrder addDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().add(dailyOrder);
		dailyOrder.setScheme(this);

		return dailyOrder;
	}

	public DailyOrder removeDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().remove(dailyOrder);
		dailyOrder.setScheme(null);

		return dailyOrder;
	}

}