package com.org.dabbaa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_status database table.
 * 
 */
@Entity
@Table(catalog="dabbaawala" , name="order_status")
@NamedQuery(name="OrderStatus.findAll", query="SELECT o FROM OrderStatus o")
public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_STATUS_ID", unique=true, nullable=false)
	private int orderStatusId;

	@Column(nullable=false, length=45)
	private String description;

	public OrderStatus() {
	}

	public int getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}