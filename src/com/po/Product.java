package com.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PRODUCT", schema = "ADMIN")
public class Product implements java.io.Serializable {

	// Fields

	private Integer prodId;
	private String prodName;
	private String prodType;
	private String prodBatch;
	private String prodUnit;
	private Integer prodPrice;
	private String prodMemo;
	private Integer prodTotal;
	private Set<Storage> storages = new HashSet<Storage>(0);
	private Set<OrdersLine> ordersLines = new HashSet<OrdersLine>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String prodName, String prodType, String prodBatch,
			String prodUnit, Integer prodPrice, String prodMemo,
			Integer prodTotal, Set<Storage> storages,
			Set<OrdersLine> ordersLines) {
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodBatch = prodBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodMemo = prodMemo;
		this.prodTotal = prodTotal;
		this.storages = storages;
		this.ordersLines = ordersLines;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PROD_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Column(name = "PROD_NAME", length = 200)
	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "PROD_TYPE", length = 100)
	public String getProdType() {
		return this.prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	@Column(name = "PROD_BATCH", length = 100)
	public String getProdBatch() {
		return this.prodBatch;
	}

	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}

	@Column(name = "PROD_UNIT", length = 10)
	public String getProdUnit() {
		return this.prodUnit;
	}

	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}

	@Column(name = "PROD_PRICE", precision = 9, scale = 0)
	public Integer getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Column(name = "PROD_MEMO", length = 200)
	public String getProdMemo() {
		return this.prodMemo;
	}

	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}

	@Column(name = "PROD_TOTAL", precision = 9, scale = 0)
	public Integer getProdTotal() {
		return this.prodTotal;
	}

	public void setProdTotal(Integer prodTotal) {
		this.prodTotal = prodTotal;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Storage> getStorages() {
		return this.storages;
	}

	public void setStorages(Set<Storage> storages) {
		this.storages = storages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public Set<OrdersLine> getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set<OrdersLine> ordersLines) {
		this.ordersLines = ordersLines;
	}

}