package com.memorystack.dto;

import java.util.List;

public class ExamInfo 
{
	public String getQuizid() {
		return quizid;
	}

	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}

	private String examId;
	private String studentUserId;
	private List<ExamDto> questions;
	private String quizid;
	public ExamInfo() {
	}
	
	public ExamInfo(String examId, String studentUserId, List<ExamDto> questions,String quizid) {
		super();
		this.examId = examId;
		this.studentUserId = studentUserId;
		this.questions = questions;
		this.quizid = quizid;
	}

	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public String getStudentUserId() {
		return studentUserId;
	}
	public void setStudentUserId(String studentUserId) {
		this.studentUserId = studentUserId;
	}
	public List<ExamDto> getQuestions() {
		return questions;
	}
	public void setQuestions(List<ExamDto> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "ExamInfo [examId=" + examId + ", studentUserId=" + studentUserId + ", questions=" + questions + ",quizid="+quizid+"]";
	}
	
}
