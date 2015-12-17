package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tiffin_type database table.
 * 
 */
@Entity
@Table(name="tiffin_type")
@NamedQuery(name="TiffinType.findAll", query="SELECT t FROM TiffinType t")
public class TiffinType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIFFIN_TYPE_ID")
	private int tiffinTypeId;

	private String description;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="tiffinType",fetch=FetchType.LAZY)
	private Set<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="tiffinType",fetch=FetchType.LAZY)
	private Set<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="tiffinType",fetch=FetchType.LAZY)
	private Set<Menu> menus;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="tiffinType",fetch=FetchType.LAZY)
	private Set<Rate> rates;

	public TiffinType() {
	}

	public int getTiffinTypeId() {
		return this.tiffinTypeId;
	}

	public void setTiffinTypeId(int tiffinTypeId) {
		this.tiffinTypeId = tiffinTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(Set<CustomizedOrder> customizedOrders) {
		this.customizedOrders = customizedOrders;
	}

	public CustomizedOrder addCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().add(customizedOrder);
		customizedOrder.setTiffinType(this);

		return customizedOrder;
	}

	public CustomizedOrder removeCustomizedOrder(CustomizedOrder customizedOrder) {
		getCustomizedOrders().remove(customizedOrder);
		customizedOrder.setTiffinType(null);

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
		dailyOrder.setTiffinType(this);

		return dailyOrder;
	}

	public DailyOrder removeDailyOrder(DailyOrder dailyOrder) {
		getDailyOrders().remove(dailyOrder);
		dailyOrder.setTiffinType(null);

		return dailyOrder;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setTiffinType(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setTiffinType(null);

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
		rate.setTiffinType(this);

		return rate;
	}

	public Rate removeRate(Rate rate) {
		getRates().remove(rate);
		rate.setTiffinType(null);

		return rate;
	}

}