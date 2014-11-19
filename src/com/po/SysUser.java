package com.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_USER", schema = "ADMIN")
public class SysUser implements java.io.Serializable {

	// Fields

	private Integer usrId;
	private String usrName;
	private String usrPassword;
	private String usrRoleName;
	private Short usrAlevel;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(String usrName, String usrPassword, String usrRoleName,
			Short usrAlevel) {
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrRoleName = usrRoleName;
		this.usrAlevel = usrAlevel;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USR_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public Integer getUsrId() {
		return this.usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	@Column(name = "USR_NAME", length = 50)
	public String getUsrName() {
		return this.usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	@Column(name = "USR_PASSWORD", length = 50)
	public String getUsrPassword() {
		return this.usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	@Column(name = "USR_ROLE_NAME", length = 50)
	public String getUsrRoleName() {
		return this.usrRoleName;
	}

	public void setUsrRoleName(String usrRoleName) {
		this.usrRoleName = usrRoleName;
	}

	@Column(name = "USR_ALEVEL", precision = 4, scale = 0)
	public Short getUsrAlevel() {
		return this.usrAlevel;
	}

	public void setUsrAlevel(Short usrAlevel) {
		this.usrAlevel = usrAlevel;
	}

}