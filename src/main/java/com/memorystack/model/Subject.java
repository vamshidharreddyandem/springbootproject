package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "subjects")
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Column(name = "adminid",columnDefinition = "varchar(50)", nullable = false)
	private String adminId;

	@Id
	@Column(name = "subjectname", columnDefinition = "varchar(50)", nullable = false)
	private String subjectName;

	public Subject() {
	}

	public Subject(String adminId, String subjectName) {
		super();
		this.adminId = adminId;
		this.subjectName = subjectName;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	@Override
	public String toString() {
		return "Subject [adminId=" + adminId + ", subjectName=" + subjectName + "]";
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
