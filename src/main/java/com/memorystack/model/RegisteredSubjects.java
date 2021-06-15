package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="registeredsubjects")
public class RegisteredSubjects implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="registrationId")
    private Long registrationId;
	
	@NotBlank
	@Column(name="userid")
    private int userId;
	
	@NotBlank
	@Column(name="subjectname")
	private String subjectname;

	public RegisteredSubjects() {
		
	}
	public RegisteredSubjects(Long registrationId, int userId, String subjectname) {
		
		this.registrationId = registrationId;
		this.userId = userId;
		this.subjectname = subjectname;
	}
	
	public Long getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getSubjectname() {
		return subjectname;
	}


	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	
	@Override
	public String toString() {
		return "RegisteredSubjects [registrationId=" + registrationId + ", userId=" + userId + ", subjectname="
				+ subjectname + "]";
	}
	
}
