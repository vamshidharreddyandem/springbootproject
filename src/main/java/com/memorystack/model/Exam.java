package com.memorystack.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "exam")
public class Exam implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "examid", columnDefinition = "varchar(30)")
	private Integer examId;
	@Column(name = "studentuserid", columnDefinition = "varchar(30)")
	private String studentUserId;
	@Column(name = "questionid", columnDefinition = "varchar(30)")
	private int questionId;
	@Column(name = "questionnumber", columnDefinition = "varchar(30)")
	private int questionNumber;
	@Column(name = "question", columnDefinition = "varchar(100)", nullable = false)
	private String question;
	@Column(name = "optionn", columnDefinition = "varchar(100)", nullable = false)
	private String option;
	@Column(name = "answer", columnDefinition = "varchar(100)", nullable = false)
	private String answer;
	public Exam() {
	}
	public Exam(Integer examId, String studentUserId, int questionId, int questionNumber, String question,
			String option, String answer) {
		super();
		this.examId = examId;
		this.studentUserId = studentUserId;
		this.questionId = questionId;
		this.questionNumber = questionNumber;
		this.question = question;
		this.option = option;
		this.answer = answer;
	}
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public String getStudentUserId() {
		return studentUserId;
	}
	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", studentUserId=" + studentUserId + ", questionId=" + questionId
				+ ", questionNumber=" + questionNumber + ", question=" + question + ", option=" + option + ", answer="
				+ answer + "]";
	}
	
}
