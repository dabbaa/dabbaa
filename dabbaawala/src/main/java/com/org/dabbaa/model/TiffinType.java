package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tiffin_type database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="tiffin_type")
@NamedQuery(name="TiffinType.findAll", query="SELECT t FROM TiffinType t")
public class TiffinType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TIFFIN_TYPE_ID", unique=true, nullable=false)
	private int tiffinTypeId;

	@Column(nullable=false, length=45)
	private String description;

	//bi-directional many-to-one association to CustomizedOrder
	@OneToMany(mappedBy="tiffinType", fetch=FetchType.EAGER)
	private List<CustomizedOrder> customizedOrders;

	//bi-directional many-to-one association to DailyOrder
	@OneToMany(mappedBy="tiffinType", fetch=FetchType.EAGER)
	private List<DailyOrder> dailyOrders;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="tiffinType", fetch=FetchType.EAGER)
	private List<Menu> menus;

	//bi-directional many-to-one association to Rate
	@OneToMany(mappedBy="tiffinType", fetch=FetchType.EAGER)
	private List<Rate> rates;

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

	public List<CustomizedOrder> getCustomizedOrders() {
		return this.customizedOrders;
	}

	public void setCustomizedOrders(List<CustomizedOrder> customizedOrders) {
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

	public List<DailyOrder> getDailyOrders() {
		return this.dailyOrders;
	}

	public void setDailyOrders(List<DailyOrder> dailyOrders) {
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

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
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

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
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