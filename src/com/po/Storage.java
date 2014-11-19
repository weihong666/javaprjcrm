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
 * Storage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "STORAGE", schema = "ADMIN")
public class Storage implements java.io.Serializable {

	// Fields

	private Integer stkId;
	private Product product;
	private String stkWarehouse;
	private String stkWare;
	private Integer stkCount;
	private String stkMemo;

	// Constructors

	/** default constructor */
	public Storage() {
	}

	/** full constructor */
	public Storage(Product product, String stkWarehouse, String stkWare,
			Integer stkCount, String stkMemo) {
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "STK_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getStkId() {
		return this.stkId;
	}

	public void setStkId(Integer stkId) {
		this.stkId = stkId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STK_PROD_ID")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "STK_WAREHOUSE", length = 50)
	public String getStkWarehouse() {
		return this.stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	@Column(name = "STK_WARE", length = 50)
	public String getStkWare() {
		return this.stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	@Column(name = "STK_COUNT", precision = 9, scale = 0)
	public Integer getStkCount() {
		return this.stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	@Column(name = "STK_MEMO", length = 200)
	public String getStkMemo() {
		return this.stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

}