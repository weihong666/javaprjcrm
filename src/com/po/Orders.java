package com.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ORDERS", schema = "ADMIN")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer odrId;
	private CstCustomer cstCustomer;
	private String odrCustomer;
	private Date odrDate;
	private String odrAddr;
	private Integer odrStatus;
	private Integer odrTotal;
	private Set<OrdersLine> ordersLines = new HashSet<OrdersLine>(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(CstCustomer cstCustomer, String odrCustomer, Date odrDate,
			String odrAddr, Integer odrStatus, Integer odrTotal,
			Set<OrdersLine> ordersLines) {
		this.cstCustomer = cstCustomer;
		this.odrCustomer = odrCustomer;
		this.odrDate = odrDate;
		this.odrAddr = odrAddr;
		this.odrStatus = odrStatus;
		this.odrTotal = odrTotal;
		this.ordersLines = ordersLines;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ODR_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getOdrId() {
		return this.odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ODR_CUST_NO")
	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	@Column(name = "ODR_CUSTOMER", length = 100)
	public String getOdrCustomer() {
		return this.odrCustomer;
	}

	public void setOdrCustomer(String odrCustomer) {
		this.odrCustomer = odrCustomer;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ODR_DATE", length = 7)
	public Date getOdrDate() {
		return this.odrDate;
	}

	public void setOdrDate(Date odrDate) {
		this.odrDate = odrDate;
	}

	@Column(name = "ODR_ADDR", length = 200)
	public String getOdrAddr() {
		return this.odrAddr;
	}

	public void setOdrAddr(String odrAddr) {
		this.odrAddr = odrAddr;
	}

	@Column(name = "ODR_STATUS", precision = 9, scale = 0)
	public Integer getOdrStatus() {
		return this.odrStatus;
	}

	public void setOdrStatus(Integer odrStatus) {
		this.odrStatus = odrStatus;
	}

	@Column(name = "ODR_TOTAL", precision = 9, scale = 0)
	public Integer getOdrTotal() {
		return this.odrTotal;
	}

	public void setOdrTotal(Integer odrTotal) {
		this.odrTotal = odrTotal;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	public Set<OrdersLine> getOrdersLines() {
		return this.ordersLines;
	}

	public void setOrdersLines(Set<OrdersLine> ordersLines) {
		this.ordersLines = ordersLines;
	}

}