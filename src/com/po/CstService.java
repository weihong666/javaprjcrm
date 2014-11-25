package com.po;

import java.math.*;
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
 * CstService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CST_SERVICE", schema = "ADMIN")
public class CstService implements java.io.Serializable {

	// Fields

	private Integer svrId;
	private CstCustomer cstCustomer;
	private String svrType;
	private String svrTitle;
	private String svrCustName;
	private String svrStatus;
	private String svrRequest;
	private Integer svrCreateId;
	private String svrCreateBy;
	private Date svrCreateDate;
	private Integer svrDueId;
	private String svrDueTo;
	private Date svrDueDate;
	private String svrDeal;
	private Integer svrDealId;
	private String svrDealBy;
	private Date svrDealDate;
	private String svrResult;
	private Integer svrSatisfy;

	// Constructors

	/** default constructor */
	public CstService() {
	}

	/** full constructor */
	public CstService(CstCustomer cstCustomer, String svrType, String svrTitle,
			String svrCustName, String svrStatus, String svrRequest,
			Integer svrCreateId, String svrCreateBy, Date svrCreateDate,
			Integer svrDueId, String svrDueTo, Date svrDueDate,
			String svrDeal, Integer svrDealId, String svrDealBy,
			Date svrDealDate, String svrResult, Integer svrSatisfy) {
		this.cstCustomer = cstCustomer;
		this.svrType = svrType;
		this.svrTitle = svrTitle;
		this.svrCustName = svrCustName;
		this.svrStatus = svrStatus;
		this.svrRequest = svrRequest;
		this.svrCreateId = svrCreateId;
		this.svrCreateBy = svrCreateBy;
		this.svrCreateDate = svrCreateDate;
		this.svrDueId = svrDueId;
		this.svrDueTo = svrDueTo;
		this.svrDueDate = svrDueDate;
		this.svrDeal = svrDeal;
		this.svrDealId = svrDealId;
		this.svrDealBy = svrDealBy;
		this.svrDealDate = svrDealDate;
		this.svrResult = svrResult;
		this.svrSatisfy = svrSatisfy;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SVR_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getSvrId() {
		return this.svrId;
	}

	public void setSvrId(Integer svrId) {
		this.svrId = svrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SVR_CUST_NO")
	public CstCustomer getCstCustomer() {
		return this.cstCustomer;
	}

	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}

	@Column(name = "SVR_TYPE", length = 20)
	public String getSvrType() {
		return this.svrType;
	}

	public void setSvrType(String svrType) {
		this.svrType = svrType;
	}

	@Column(name = "SVR_TITLE", length = 500)
	public String getSvrTitle() {
		return this.svrTitle;
	}

	public void setSvrTitle(String svrTitle) {
		this.svrTitle = svrTitle;
	}

	@Column(name = "SVR_CUST_NAME", length = 100)
	public String getSvrCustName() {
		return this.svrCustName;
	}

	public void setSvrCustName(String svrCustName) {
		this.svrCustName = svrCustName;
	}

	@Column(name = "SVR_STATUS", length = 10)
	public String getSvrStatus() {
		return this.svrStatus;
	}

	public void setSvrStatus(String svrStatus) {
		this.svrStatus = svrStatus;
	}

	@Column(name = "SVR_REQUEST", length = 3000)
	public String getSvrRequest() {
		return this.svrRequest;
	}

	public void setSvrRequest(String svrRequest) {
		this.svrRequest = svrRequest;
	}

	@Column(name = "SVR_CREATE_ID", precision = 22, scale = 0)
	public Integer getSvrCreateId() {
		return this.svrCreateId;
	}

	public void setSvrCreateId(Integer svrCreateId) {
		this.svrCreateId = svrCreateId;
	}

	@Column(name = "SVR_CREATE_BY", length = 50)
	public String getSvrCreateBy() {
		return this.svrCreateBy;
	}

	public void setSvrCreateBy(String svrCreateBy) {
		this.svrCreateBy = svrCreateBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SVR_CREATE_DATE", length = 7)
	public Date getSvrCreateDate() {
		return this.svrCreateDate;
	}

	public void setSvrCreateDate(Date svrCreateDate) {
		this.svrCreateDate = svrCreateDate;
	}

	@Column(name = "SVR_DUE_ID", precision = 22, scale = 0)
	public Integer getSvrDueId() {
		return this.svrDueId;
	}

	public void setSvrDueId(Integer svrDueId) {
		this.svrDueId = svrDueId;
	}

	@Column(name = "SVR_DUE_TO", length = 50)
	public String getSvrDueTo() {
		return this.svrDueTo;
	}

	public void setSvrDueTo(String svrDueTo) {
		this.svrDueTo = svrDueTo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SVR_DUE_DATE", length = 7)
	public Date getSvrDueDate() {
		return this.svrDueDate;
	}

	public void setSvrDueDate(Date svrDueDate) {
		this.svrDueDate = svrDueDate;
	}

	@Column(name = "SVR_DEAL", length = 3000)
	public String getSvrDeal() {
		return this.svrDeal;
	}

	public void setSvrDeal(String svrDeal) {
		this.svrDeal = svrDeal;
	}

	@Column(name = "SVR_DEAL_ID", precision = 22, scale = 0)
	public Integer getSvrDealId() {
		return this.svrDealId;
	}

	public void setSvrDealId(Integer svrDealId) {
		this.svrDealId = svrDealId;
	}

	@Column(name = "SVR_DEAL_BY", length = 50)
	public String getSvrDealBy() {
		return this.svrDealBy;
	}

	public void setSvrDealBy(String svrDealBy) {
		this.svrDealBy = svrDealBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SVR_DEAL_DATE", length = 7)
	public Date getSvrDealDate() {
		return this.svrDealDate;
	}

	public void setSvrDealDate(Date svrDealDate) {
		this.svrDealDate = svrDealDate;
	}

	@Column(name = "SVR_RESULT", length = 500)
	public String getSvrResult() {
		return this.svrResult;
	}

	public void setSvrResult(String svrResult) {
		this.svrResult = svrResult;
	}

	@Column(name = "SVR_SATISFY", precision = 9, scale = 0)
	public Integer getSvrSatisfy() {
		return this.svrSatisfy;
	}

	public void setSvrSatisfy(Integer svrSatisfy) {
		this.svrSatisfy = svrSatisfy;
	}

}