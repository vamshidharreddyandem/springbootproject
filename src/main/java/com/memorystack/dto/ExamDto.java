package com.memorystack.dto;

public class ExamDto 
{
	private Integer questionId;
	private Integer questionNumber;
	private String question;
	private String option;
	public ExamDto() {
		// TODO Auto-generated constructor stub
	}
	public ExamDto(Integer questionId, Integer questionNumber, String question, String option) {
		super();
		this.questionId = questionId;
		this.questionNumber = questionNumber;
		this.question = question;
		this.option = option;
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
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	@Override
	public String toString() {
		return "ExamDto [questionId=" + questionId + ", questionNumber=" + questionNumber + ", question=" + question
				+ ", option=" + option + "]";
	}
	
}
