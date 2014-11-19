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
 * SalPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SAL_PLAN", schema = "ADMIN")
public class SalPlan implements java.io.Serializable {

	// Fields

	private Integer plaId;
	private SalChance salChance;
	private Date plaDate;
	private String plaTodo;
	private String plaResult;

	// Constructors

	/** default constructor */
	public SalPlan() {
	}

	/** minimal constructor */
	public SalPlan(Date plaDate, String plaTodo) {
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
	}

	/** full constructor */
	public SalPlan(SalChance salChance, Date plaDate, String plaTodo,
			String plaResult) {
		this.salChance = salChance;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "PLA_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PLA_CHC_ID")
	public SalChance getSalChance() {
		return this.salChance;
	}

	public void setSalChance(SalChance salChance) {
		this.salChance = salChance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PLA_DATE", nullable = false, length = 7)
	public Date getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Date plaDate) {
		this.plaDate = plaDate;
	}

	@Column(name = "PLA_TODO", nullable = false, length = 50)
	public String getPlaTodo() {
		return this.plaTodo;
	}

	public void setPlaTodo(String plaTodo) {
		this.plaTodo = plaTodo;
	}

	@Column(name = "PLA_RESULT", length = 50)
	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}