package com.po;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * BasDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BAS_DICT", schema = "ADMIN")
public class BasDict implements java.io.Serializable {

	// Fields

	private Integer dictId;
	private String dictType;
	private String dictItem;
	private String dictValue;
	private BigDecimal dictIsEditable;

	// Constructors

	/** default constructor */
	public BasDict() {
	}

	/** full constructor */
	public BasDict(String dictType, String dictItem, String dictValue,
			BigDecimal dictIsEditable) {
		this.dictType = dictType;
		this.dictItem = dictItem;
		this.dictValue = dictValue;
		this.dictIsEditable = dictIsEditable;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "DICT_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	@Column(name = "DICT_TYPE", length = 50)
	public String getDictType() {
		return this.dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	@Column(name = "DICT_ITEM", length = 50)
	public String getDictItem() {
		return this.dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	@Column(name = "DICT_VALUE", length = 50)
	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	@Column(name = "DICT_IS_EDITABLE", precision = 22, scale = 0)
	public BigDecimal getDictIsEditable() {
		return this.dictIsEditable;
	}

	public void setDictIsEditable(BigDecimal dictIsEditable) {
		this.dictIsEditable = dictIsEditable;
	}

}