package com.po;

import java.math.BigDecimal;
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
 * CstCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CST_CUSTOMER", schema = "ADMIN")
public class CstCustomer implements java.io.Serializable {

	// Fields

	private Integer custId;
	private String custNo;
	private String custName;
	private String custRegion;
	private BigDecimal custManagerId;
	private String custManagerName;
	private BigDecimal custLevel;
	private String custLevelLabel;
	private BigDecimal custSatisfy;
	private BigDecimal custCredit;
	private String custAddr;
	private String custZip;
	private String custTel;
	private String custFax;
	private String custWebsite;
	private String custLicenceNo;
	private String custChieftain;
	private BigDecimal custBankroll;
	private BigDecimal custTurnover;
	private String custBank;
	private String custBankAccount;
	private String custLocalTaxNo;
	private String custNationalTaxNo;
	private Integer custStatus;
	private Set<CstActivity> cstActivities = new HashSet<CstActivity>(0);
	private Set<CstService> cstServices = new HashSet<CstService>(0);
	private Set<CstLost> cstLosts = new HashSet<CstLost>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<CstLinkman> cstLinkmans = new HashSet<CstLinkman>(0);

	// Constructors

	/** default constructor */
	public CstCustomer() {
	}

	/** full constructor */
	public CstCustomer(String custNo, String custName, String custRegion,
			BigDecimal custManagerId, String custManagerName,
			BigDecimal custLevel, String custLevelLabel,
			BigDecimal custSatisfy, BigDecimal custCredit, String custAddr,
			String custZip, String custTel, String custFax, String custWebsite,
			String custLicenceNo, String custChieftain,
			BigDecimal custBankroll, BigDecimal custTurnover, String custBank,
			String custBankAccount, String custLocalTaxNo,
			String custNationalTaxNo, Integer custStatus,
			Set<CstActivity> cstActivities, Set<CstService> cstServices,
			Set<CstLost> cstLosts, Set<Orders> orderses,
			Set<CstLinkman> cstLinkmans) {
		this.custNo = custNo;
		this.custName = custName;
		this.custRegion = custRegion;
		this.custManagerId = custManagerId;
		this.custManagerName = custManagerName;
		this.custLevel = custLevel;
		this.custLevelLabel = custLevelLabel;
		this.custSatisfy = custSatisfy;
		this.custCredit = custCredit;
		this.custAddr = custAddr;
		this.custZip = custZip;
		this.custTel = custTel;
		this.custFax = custFax;
		this.custWebsite = custWebsite;
		this.custLicenceNo = custLicenceNo;
		this.custChieftain = custChieftain;
		this.custBankroll = custBankroll;
		this.custTurnover = custTurnover;
		this.custBank = custBank;
		this.custBankAccount = custBankAccount;
		this.custLocalTaxNo = custLocalTaxNo;
		this.custNationalTaxNo = custNationalTaxNo;
		this.custStatus = custStatus;
		this.cstActivities = cstActivities;
		this.cstServices = cstServices;
		this.cstLosts = cstLosts;
		this.orderses = orderses;
		this.cstLinkmans = cstLinkmans;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CUST_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Column(name = "CUST_NO", length = 20)
	public String getCustNo() {
		return this.custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	@Column(name = "CUST_NAME", length = 100)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "CUST_REGION", length = 50)
	public String getCustRegion() {
		return this.custRegion;
	}

	public void setCustRegion(String custRegion) {
		this.custRegion = custRegion;
	}

	@Column(name = "CUST_MANAGER_ID", precision = 22, scale = 0)
	public BigDecimal getCustManagerId() {
		return this.custManagerId;
	}

	public void setCustManagerId(BigDecimal custManagerId) {
		this.custManagerId = custManagerId;
	}

	@Column(name = "CUST_MANAGER_NAME", length = 50)
	public String getCustManagerName() {
		return this.custManagerName;
	}

	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName;
	}

	@Column(name = "CUST_LEVEL", precision = 22, scale = 0)
	public BigDecimal getCustLevel() {
		return this.custLevel;
	}

	public void setCustLevel(BigDecimal custLevel) {
		this.custLevel = custLevel;
	}

	@Column(name = "CUST_LEVEL_LABEL", length = 50)
	public String getCustLevelLabel() {
		return this.custLevelLabel;
	}

	public void setCustLevelLabel(String custLevelLabel) {
		this.custLevelLabel = custLevelLabel;
	}

	@Column(name = "CUST_SATISFY", precision = 22, scale = 0)
	public BigDecimal getCustSatisfy() {
		return this.custSatisfy;
	}

	public void setCustSatisfy(BigDecimal custSatisfy) {
		this.custSatisfy = custSatisfy;
	}

	@Column(name = "CUST_CREDIT", precision = 22, scale = 0)
	public BigDecimal getCustCredit() {
		return this.custCredit;
	}

	public void setCustCredit(BigDecimal custCredit) {
		this.custCredit = custCredit;
	}

	@Column(name = "CUST_ADDR", length = 300)
	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	@Column(name = "CUST_ZIP", length = 50)
	public String getCustZip() {
		return this.custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	@Column(name = "CUST_TEL", length = 50)
	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	@Column(name = "CUST_FAX", length = 50)
	public String getCustFax() {
		return this.custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	@Column(name = "CUST_WEBSITE", length = 50)
	public String getCustWebsite() {
		return this.custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	@Column(name = "CUST_LICENCE_NO", length = 50)
	public String getCustLicenceNo() {
		return this.custLicenceNo;
	}

	public void setCustLicenceNo(String custLicenceNo) {
		this.custLicenceNo = custLicenceNo;
	}

	@Column(name = "CUST_CHIEFTAIN", length = 50)
	public String getCustChieftain() {
		return this.custChieftain;
	}

	public void setCustChieftain(String custChieftain) {
		this.custChieftain = custChieftain;
	}

	@Column(name = "CUST_BANKROLL", precision = 22, scale = 0)
	public BigDecimal getCustBankroll() {
		return this.custBankroll;
	}

	public void setCustBankroll(BigDecimal custBankroll) {
		this.custBankroll = custBankroll;
	}

	@Column(name = "CUST_TURNOVER", precision = 22, scale = 0)
	public BigDecimal getCustTurnover() {
		return this.custTurnover;
	}

	public void setCustTurnover(BigDecimal custTurnover) {
		this.custTurnover = custTurnover;
	}

	@Column(name = "CUST_BANK", length = 200)
	public String getCustBank() {
		return this.custBank;
	}

	public void setCustBank(String custBank) {
		this.custBank = custBank;
	}

	@Column(name = "CUST_BANK_ACCOUNT", length = 50)
	public String getCustBankAccount() {
		return this.custBankAccount;
	}

	public void setCustBankAccount(String custBankAccount) {
		this.custBankAccount = custBankAccount;
	}

	@Column(name = "CUST_LOCAL_TAX_NO", length = 50)
	public String getCustLocalTaxNo() {
		return this.custLocalTaxNo;
	}

	public void setCustLocalTaxNo(String custLocalTaxNo) {
		this.custLocalTaxNo = custLocalTaxNo;
	}

	@Column(name = "CUST_NATIONAL_TAX_NO", length = 50)
	public String getCustNationalTaxNo() {
		return this.custNationalTaxNo;
	}

	public void setCustNationalTaxNo(String custNationalTaxNo) {
		this.custNationalTaxNo = custNationalTaxNo;
	}

	@Column(name = "CUST_STATUS", precision = 4, scale = 0)
	public Integer getCustStatus() {
		return this.custStatus;
	}

	public void setCustStatus(Integer custStatus) {
		this.custStatus = custStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstCustomer")
	public Set<CstActivity> getCstActivities() {
		return this.cstActivities;
	}

	public void setCstActivities(Set<CstActivity> cstActivities) {
		this.cstActivities = cstActivities;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstCustomer")
	public Set<CstService> getCstServices() {
		return this.cstServices;
	}

	public void setCstServices(Set<CstService> cstServices) {
		this.cstServices = cstServices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstCustomer")
	public Set<CstLost> getCstLosts() {
		return this.cstLosts;
	}

	public void setCstLosts(Set<CstLost> cstLosts) {
		this.cstLosts = cstLosts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstCustomer")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cstCustomer")
	public Set<CstLinkman> getCstLinkmans() {
		return this.cstLinkmans;
	}

	public void setCstLinkmans(Set<CstLinkman> cstLinkmans) {
		this.cstLinkmans = cstLinkmans;
	}

}