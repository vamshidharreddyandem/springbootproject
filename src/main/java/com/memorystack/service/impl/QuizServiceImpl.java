package com.memorystack.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Question;
import com.memorystack.model.Quiz;
import com.memorystack.repositories.QuestionRepo;
import com.memorystack.repositories.QuizRepo;
import com.memorystack.service.IQuizService;
@Service
public class QuizServiceImpl implements IQuizService {

	protected static Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);
	@Autowired
	public QuizRepo quizRepo;
	@Autowired
	public QuestionRepo questionRepo;
	@Override
	public ResponseDto saveQuiz(Quiz entity) {
		ResponseDto dto=new ResponseDto();
		log.info("entity={}",entity);
		String dbquizname = quizRepo.checkIsQuizExist(entity.getAdminId(), entity.getSubjectName(), entity.getQuizName(), entity.getQuizType());
		log.info("db result1={}",(dbquizname==null));
		List<String> quizTypes=Arrays.asList("EASY","HARD","MEDIUM");
		if(!quizTypes.contains(entity.getQuizType()))
		{
			dto.setStatus(Boolean.FALSE);
			dto.setMessage(Constants.INVALID_QUIZ_TYPE);
		}
		else if(dbquizname!=null)
		{
			dto.setStatus(Boolean.FALSE);
			dto.setMessage(Constants.QUIZ_ADDED_FAILED);
		}
		else 
		{
			log.info("result ={}", quizRepo.save(entity));
			dto.setMessage(Constants.QUIZ_ADDED_SUCCESS);
		}
		return dto;
	}
	@Override
	public List<Quiz> showAllQuizs() {
		return quizRepo.findAll();
	}

	@Override
	public Optional<Quiz> showQuizById(Integer qid) {
		return quizRepo.findById(qid);
	}
	@Override
	public List<Question> getQuizData(String quizid) {
		// TODO Auto-generated method stub
		return  questionRepo.getQuizData(quizid);
	}
	public List<Quiz> getQuizList(String subjectname) {
		// TODO Auto-generated method stub
		return quizRepo.getQuizList(subjectname);
	}
}
