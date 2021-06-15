package com.memorystack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "quiz")
public class Quiz implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="quizid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quizId;
	
	@Column(name = "adminid", columnDefinition = "varchar(100)", nullable = false)
	private String adminId;
		
	@Column(name = "subjectname", columnDefinition = "varchar(100)", nullable = false)
	private String subjectName;
	
	@Column(name = "quizname", columnDefinition = "varchar(100)", nullable = false)
	private String quizName;
	
	@Column(name = "quiztype", columnDefinition = "varchar(100)", nullable = false)
	private String quizType;
	
	@Column(name = "questioncount", columnDefinition = "ineteger", nullable = false)
	private Integer questionCount;
	public Quiz() {
	}
	public Quiz(Integer quizId, String adminId, String subjectName, String quizName, String quizType,
			Integer questionCount) {
		super();
		this.quizId = quizId;
		this.adminId = adminId;
		this.subjectName = subjectName;
		this.quizName = quizName;
		this.quizType = quizType;
		this.questionCount = questionCount;
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	public Integer getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", adminId=" + adminId + ", subjectName=" + subjectName + ", quizName="
				+ quizName + ", quizType=" + quizType + ", questionCount=" + questionCount + "]";
	}
	
	
}
