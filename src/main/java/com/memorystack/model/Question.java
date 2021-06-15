package com.memorystack.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "questions")
public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "questionid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionId;
	@Column(name = "quizid", columnDefinition = "ineteger", nullable = false)
	private Integer quizId;
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	@Column(name = "subjectname", columnDefinition = "varchar(50)", nullable = false)
	private String subjectName;
	@Column(name = "quizname", columnDefinition = "varchar(100)", nullable = false)
	private String quizName;
	@Column(name = "quiztype", columnDefinition = "varchar(100)", nullable = false)
	private String quizType;
	@Column(name = "questionnumber", columnDefinition = "varchar(30)", nullable = false)
	private Integer questionNumber;
	@Column(name = "question", columnDefinition = "varchar(100)", nullable = false)
	private String question;
	@Column(name = "opt1", columnDefinition = "varchar(100)", nullable = false)
	private String opt1;
	@Column(name = "opt2", columnDefinition = "varchar(100)", nullable = false)
	private String opt2;
	@Column(name = "opt3", columnDefinition = "varchar(100)", nullable = false)
	private String opt3;
	@Column(name = "opt4", columnDefinition = "varchar(100)", nullable = false)
	private String opt4;
	@Column(name = "ans", columnDefinition = "varchar(100)", nullable = false)
	private String ans;
	public Question() {
	}
	public Question(Integer quesionId, Integer questionNumber, String question, String opt1, String opt2, String opt3,
			String opt4, String ans) {
		super();
		this.questionId = quesionId;
		this.questionNumber = questionNumber;
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.ans = ans;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
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
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", subjectName=" + subjectName + ", quizName=" + quizName
				+ ", quizType=" + quizType + ", questionNumber=" + questionNumber + ", question=" + question + ", opt1="
				+ opt1 + ", opt2=" + opt2 + ", opt3=" + opt3 + ", opt4=" + opt4 + ", ans=" + ans + "]";
	}
	
}
