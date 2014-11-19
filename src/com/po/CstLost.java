package com.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * CstLost entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CST_LOST", schema = "ADMIN")
public class CstLost implements java.io.Serializable {

	// Fields

	private Integer lstId;
	private CstCustomer cstCustomer;
	private String lstCustName;
	private BigDecimal lstCustManagerId;
	private String lstCustManagerName;
	private Date lstLastOrderDate;
	private Date lstLostDate;
	private String lstDelay;
	private String lstReason;
	private String lstStatus;

	// Constructors

	/** default constructor */
	public CstLost() {
	}

	/** full constructor */
	public CstLost(CstCustomer cstCustomer, String lstCustName,
			BigDecimal lstCustManagerId, String lstCustManagerName,
			Date lstLastOrderDate, Date lstLostDate, String lstDelay,
			String lstReason, String lstStatus) {
		this.cstCustomer = cstCustomer;
		this.lstCustName = lstCustName;
		this.lstCustManagerId = lstCustManagerId;
		this.lstCustManagerName = lstCustManagerName;
		this.lstLastOrderDate = lstLastOrderDate;
		this.lstLostDate = lstLostDate;
		this.lstDelay = lstDelay;
		this.lstReason = lstReason;
		this.lstStatus = lstStatus;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "LST_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getLstId() {
		return this.lstId;
	}

	public void setLstId(Integer lstId) {
		this.lstId = lstId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LST_CUST_NO")
	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	@Column(name = "LST_CUST_NAME", length = 100)
	public String getLstCustName() {
		return this.lstCustName;
	}

	public void setLstCustName(String lstCustName) {
		this.lstCustName = lstCustName;
	}

	@Column(name = "LST_CUST_MANAGER_ID", precision = 22, scale = 0)
	public BigDecimal getLstCustManagerId() {
		return this.lstCustManagerId;
	}

	public void setLstCustManagerId(BigDecimal lstCustManagerId) {
		this.lstCustManagerId = lstCustManagerId;
	}

	@Column(name = "LST_CUST_MANAGER_NAME", length = 50)
	public String getLstCustManagerName() {
		return this.lstCustManagerName;
	}

	public void setLstCustManagerName(String lstCustManagerName) {
		this.lstCustManagerName = lstCustManagerName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LST_LAST_ORDER_DATE", length = 7)
	public Date getLstLastOrderDate() {
		return this.lstLastOrderDate;
	}

	public void setLstLastOrderDate(Date lstLastOrderDate) {
		this.lstLastOrderDate = lstLastOrderDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LST_LOST_DATE", length = 7)
	public Date getLstLostDate() {
		return this.lstLostDate;
	}

	public void setLstLostDate(Date lstLostDate) {
		this.lstLostDate = lstLostDate;
	}

	@Column(name = "LST_DELAY", length = 4000)
	public String getLstDelay() {
		return this.lstDelay;
	}

	public void setLstDelay(String lstDelay) {
		this.lstDelay = lstDelay;
	}

	@Column(name = "LST_REASON", length = 2000)
	public String getLstReason() {
		return this.lstReason;
	}

	public void setLstReason(String lstReason) {
		this.lstReason = lstReason;
	}

	@Column(name = "LST_STATUS", length = 100)
	public String getLstStatus() {
		return this.lstStatus;
	}

	public void setLstStatus(String lstStatus) {
		this.lstStatus = lstStatus;
	}

}