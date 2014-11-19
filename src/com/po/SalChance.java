package com.po;

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * SalChance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SAL_CHANCE", schema = "ADMIN")
public class SalChance implements java.io.Serializable {

	// Fields

	private Integer chcId;
	private String chcSource;
	private String chcCustName;
	private String chcTitle;
	private BigDecimal chcRate;
	private String chcLinkman;
	private String chcTel;
	private String chcDesc;
	private BigDecimal chcCreateId;
	private String chcCreateBy;
	private Date chcCreateDate;
	private BigDecimal chcDueId;
	private String chcDueTo;
	private Date chcDueDate;
	private Integer chcStatus;
	private Set<SalPlan> salPlans = new HashSet<SalPlan>(0);

	// Constructors

	/** default constructor */
	public SalChance() {
	}

	/** full constructor */
	public SalChance(String chcSource, String chcCustName, String chcTitle,
			BigDecimal chcRate, String chcLinkman, String chcTel,
			String chcDesc, BigDecimal chcCreateId, String chcCreateBy,
			Date chcCreateDate, BigDecimal chcDueId, String chcDueTo,
			Date chcDueDate, Integer chcStatus, Set<SalPlan> salPlans) {
		this.chcSource = chcSource;
		this.chcCustName = chcCustName;
		this.chcTitle = chcTitle;
		this.chcRate = chcRate;
		this.chcLinkman = chcLinkman;
		this.chcTel = chcTel;
		this.chcDesc = chcDesc;
		this.chcCreateId = chcCreateId;
		this.chcCreateBy = chcCreateBy;
		this.chcCreateDate = chcCreateDate;
		this.chcDueId = chcDueId;
		this.chcDueTo = chcDueTo;
		this.chcDueDate = chcDueDate;
		this.chcStatus = chcStatus;
		this.salPlans = salPlans;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CHC_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getChcId() {
		return this.chcId;
	}

	public void setChcId(Integer chcId) {
		this.chcId = chcId;
	}

	@Column(name = "CHC_SOURCE", length = 50)
	public String getChcSource() {
		return this.chcSource;
	}

	public void setChcSource(String chcSource) {
		this.chcSource = chcSource;
	}

	@Column(name = "CHC_CUST_NAME", length = 100)
	public String getChcCustName() {
		return this.chcCustName;
	}

	public void setChcCustName(String chcCustName) {
		this.chcCustName = chcCustName;
	}

	@Column(name = "CHC_TITLE", length = 200)
	public String getChcTitle() {
		return this.chcTitle;
	}

	public void setChcTitle(String chcTitle) {
		this.chcTitle = chcTitle;
	}

	@Column(name = "CHC_RATE", precision = 22, scale = 0)
	public BigDecimal getChcRate() {
		return this.chcRate;
	}

	public void setChcRate(BigDecimal chcRate) {
		this.chcRate = chcRate;
	}

	@Column(name = "CHC_LINKMAN", length = 50)
	public String getChcLinkman() {
		return this.chcLinkman;
	}

	public void setChcLinkman(String chcLinkman) {
		this.chcLinkman = chcLinkman;
	}

	@Column(name = "CHC_TEL", length = 50)
	public String getChcTel() {
		return this.chcTel;
	}

	public void setChcTel(String chcTel) {
		this.chcTel = chcTel;
	}

	@Column(name = "CHC_DESC", length = 2000)
	public String getChcDesc() {
		return this.chcDesc;
	}

	public void setChcDesc(String chcDesc) {
		this.chcDesc = chcDesc;
	}

	@Column(name = "CHC_CREATE_ID", precision = 22, scale = 0)
	public BigDecimal getChcCreateId() {
		return this.chcCreateId;
	}

	public void setChcCreateId(BigDecimal chcCreateId) {
		this.chcCreateId = chcCreateId;
	}

	@Column(name = "CHC_CREATE_BY", length = 50)
	public String getChcCreateBy() {
		return this.chcCreateBy;
	}

	public void setChcCreateBy(String chcCreateBy) {
		this.chcCreateBy = chcCreateBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHC_CREATE_DATE", length = 7)
	public Date getChcCreateDate() {
		return this.chcCreateDate;
	}

	public void setChcCreateDate(Date chcCreateDate) {
		this.chcCreateDate = chcCreateDate;
	}

	@Column(name = "CHC_DUE_ID", precision = 22, scale = 0)
	public BigDecimal getChcDueId() {
		return this.chcDueId;
	}

	public void setChcDueId(BigDecimal chcDueId) {
		this.chcDueId = chcDueId;
	}

	@Column(name = "CHC_DUE_TO", length = 50)
	public String getChcDueTo() {
		return this.chcDueTo;
	}

	public void setChcDueTo(String chcDueTo) {
		this.chcDueTo = chcDueTo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHC_DUE_DATE", length = 7)
	public Date getChcDueDate() {
		return this.chcDueDate;
	}

	public void setChcDueDate(Date chcDueDate) {
		this.chcDueDate = chcDueDate;
	}

	@Column(name = "CHC_STATUS", precision = 9, scale = 0)
	public Integer getChcStatus() {
		return this.chcStatus;
	}

	public void setChcStatus(Integer chcStatus) {
		this.chcStatus = chcStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salChance")
	public Set<SalPlan> getSalPlans() {
		return this.salPlans;
	}

	public void setSalPlans(Set<SalPlan> salPlans) {
		this.salPlans = salPlans;
	}

}