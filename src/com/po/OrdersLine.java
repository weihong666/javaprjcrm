package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * OrdersLine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ORDERS_LINE", schema = "ADMIN")
public class OrdersLine implements java.io.Serializable {

	// Fields

	private Integer oddId;
	private Orders orders;
	private Product product;

	// Constructors

	/** default constructor */
	public OrdersLine() {
	}

	/** full constructor */
	public OrdersLine(Orders orders, Product product) {
		this.orders = orders;
		this.product = product;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ODD_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getOddId() {
		return this.oddId;
	}

	public void setOddId(Integer oddId) {
		this.oddId = oddId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ODD_ORDER_ID")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ODD_PROD_ID")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}