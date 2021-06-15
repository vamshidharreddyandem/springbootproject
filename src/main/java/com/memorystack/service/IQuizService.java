package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Question;
import com.memorystack.model.Quiz;



public interface IQuizService 
{
	ResponseDto saveQuiz(Quiz entity);
	List<Quiz> showAllQuizs();
	Optional<Quiz> showQuizById(Integer quizId);
	List<Question> getQuizData(String quizid);
}
