package com.po;

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
 * CstActivity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CST_ACTIVITY", schema = "ADMIN")
public class CstActivity implements java.io.Serializable {

	// Fields

	private Integer atvId;
	private CstCustomer cstCustomer;
	private String atvCustName;
	private Date atvDate;
	private String atvPlace;
	private String atvTitle;
	private String atvDesc;

	// Constructors

	/** default constructor */
	public CstActivity() {
	}

	/** minimal constructor */
	public CstActivity(Date atvDate) {
		this.atvDate = atvDate;
	}

	/** full constructor */
	public CstActivity(CstCustomer cstCustomer, String atvCustName,
			Date atvDate, String atvPlace, String atvTitle, String atvDesc) {
		this.cstCustomer = cstCustomer;
		this.atvCustName = atvCustName;
		this.atvDate = atvDate;
		this.atvPlace = atvPlace;
		this.atvTitle = atvTitle;
		this.atvDesc = atvDesc;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ATV_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getAtvId() {
		return this.atvId;
	}

	public void setAtvId(Integer atvId) {
		this.atvId = atvId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ATV_CUST_NO")
	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	@Column(name = "ATV_CUST_NAME", length = 100)
	public String getAtvCustName() {
		return this.atvCustName;
	}

	public void setAtvCustName(String atvCustName) {
		this.atvCustName = atvCustName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ATV_DATE", nullable = false, length = 7)
	public Date getAtvDate() {
		return this.atvDate;
	}

	public void setAtvDate(Date atvDate) {
		this.atvDate = atvDate;
	}

	@Column(name = "ATV_PLACE", length = 200)
	public String getAtvPlace() {
		return this.atvPlace;
	}

	public void setAtvPlace(String atvPlace) {
		this.atvPlace = atvPlace;
	}

	@Column(name = "ATV_TITLE", length = 500)
	public String getAtvTitle() {
		return this.atvTitle;
	}

	public void setAtvTitle(String atvTitle) {
		this.atvTitle = atvTitle;
	}

	@Column(name = "ATV_DESC", length = 2000)
	public String getAtvDesc() {
		return this.atvDesc;
	}

	public void setAtvDesc(String atvDesc) {
		this.atvDesc = atvDesc;
	}

}