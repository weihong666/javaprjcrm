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
 * CstLinkman entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CST_LINKMAN", schema = "ADMIN")
public class CstLinkman implements java.io.Serializable {

	// Fields

	private Integer lkmId;
	private CstCustomer cstCustomer;
	private String lkmCustName;
	private String lkmName;
	private String lkmSex;
	private String lkmPostion;
	private String lkmTel;
	private String lkmMobile;
	private String lkmMemo;

	// Constructors

	/** default constructor */
	public CstLinkman() {
	}

	/** full constructor */
	public CstLinkman(CstCustomer cstCustomer, String lkmCustName,
			String lkmName, String lkmSex, String lkmPostion, String lkmTel,
			String lkmMobile, String lkmMemo) {
		this.cstCustomer = cstCustomer;
		this.lkmCustName = lkmCustName;
		this.lkmName = lkmName;
		this.lkmSex = lkmSex;
		this.lkmPostion = lkmPostion;
		this.lkmTel = lkmTel;
		this.lkmMobile = lkmMobile;
		this.lkmMemo = lkmMemo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "LKM_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getLkmId() {
		return this.lkmId;
	}

	public void setLkmId(Integer lkmId) {
		this.lkmId = lkmId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LKM_CUST_NO")
	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	@Column(name = "LKM_CUST_NAME", length = 100)
	public String getLkmCustName() {
		return this.lkmCustName;
	}

	public void setLkmCustName(String lkmCustName) {
		this.lkmCustName = lkmCustName;
	}

	@Column(name = "LKM_NAME", length = 50)
	public String getLkmName() {
		return this.lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	@Column(name = "LKM_SEX", length = 5)
	public String getLkmSex() {
		return this.lkmSex;
	}

	public void setLkmSex(String lkmSex) {
		this.lkmSex = lkmSex;
	}

	@Column(name = "LKM_POSTION", length = 50)
	public String getLkmPostion() {
		return this.lkmPostion;
	}

	public void setLkmPostion(String lkmPostion) {
		this.lkmPostion = lkmPostion;
	}

	@Column(name = "LKM_TEL", length = 50)
	public String getLkmTel() {
		return this.lkmTel;
	}

	public void setLkmTel(String lkmTel) {
		this.lkmTel = lkmTel;
	}

	@Column(name = "LKM_MOBILE", length = 50)
	public String getLkmMobile() {
		return this.lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	@Column(name = "LKM_MEMO", length = 300)
	public String getLkmMemo() {
		return this.lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

}