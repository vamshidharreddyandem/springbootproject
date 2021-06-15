package com.memorystack.dto;

import java.util.List;

public class ExamResultInfo {
	private String studentUserId;
	private int questionsAttempted;
	private int answerCount;
	private List<ExamResultDto> answerList;
	public ExamResultInfo() {
	}
	public ExamResultInfo(String studentUserId, int questionsAttempted, int answerCount,
			List<ExamResultDto> answerList) {
		super();
		this.studentUserId = studentUserId;
		this.questionsAttempted = questionsAttempted;
		this.answerCount = answerCount;
		this.answerList = answerList;
	}
	public String getStudentUserId() {
		return studentUserId;
	}
	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}
	public int getQuestionsAttempted() {
		return questionsAttempted;
	}
	public void setQuestionsAttempted(int questionsAttempted) {
		this.questionsAttempted = questionsAttempted;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	public List<ExamResultDto> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<ExamResultDto> answerList) {
		this.answerList = answerList;
	}
	@Override
	public String toString() {
		return "ExamResultInfo [studentUserId=" + studentUserId + ", questionsAttempted=" + questionsAttempted
				+ ", answerCount=" + answerCount + ", answerList=" + answerList + "]";
	}
	
}
