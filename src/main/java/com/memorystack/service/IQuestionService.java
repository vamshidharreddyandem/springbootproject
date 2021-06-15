package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Question;



public interface IQuestionService {
	ResponseDto saveQuestion(Question entity);
	List<Question> showAllQuestions();
	Optional<Question> showQuestionById(Integer qid);
}
