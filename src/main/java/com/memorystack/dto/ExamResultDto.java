package com.memorystack.dto;

public class ExamResultDto {
	

	private Integer questionNumber;
	private String question;
	private String answer;
	private String yourAnswer;
	private String status;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	public ExamResultDto() {
	}
	public ExamResultDto(Integer questionNumber, String question, String answer, String yourAnswer, String status, String opt1,
			String opt2,String opt3,String opt4) {
		super();
		this.questionNumber = questionNumber;
		this.question = question;
		this.answer = answer;
		this.yourAnswer = yourAnswer;
		this.status = status;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "ExamResultDto [questionNumber=" + questionNumber + ", question=" + question + ", answer=" + answer
				+ ", yourAnswer=" + yourAnswer + ", status=" + status + "]";
	}
	
}
