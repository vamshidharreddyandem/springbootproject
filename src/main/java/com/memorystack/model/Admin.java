package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin")
public class Admin  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "adminid", columnDefinition = "varchar(30)")
	private String adminId;
	
	@Column(name = "password", columnDefinition = "varchar(100)", nullable = false)
	private String password;
	@Column(name = "adminname", columnDefinition = "varchar(100)", nullable = false)
	private String adminName;
	@Column(name = "emailid", columnDefinition = "varchar(30) unique",nullable = false)
	private String emailId;
	

	public Admin() {
	}
	public Admin(String adminId, String password, String adminName, String emailId) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.adminName = adminName;
		this.emailId = emailId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + ", adminName=" + adminName + ", emailId=" + emailId+"]";
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
