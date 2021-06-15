package com.memorystack.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Question;
import com.memorystack.repositories.QuestionRepo;
import com.memorystack.service.IQuestionService;
@Service
public class QuestionServiceImpl implements IQuestionService {
	protected static Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);
	@Autowired
	public QuestionRepo repo;

	@Override
	public ResponseDto saveQuestion(Question entity) 
	{
		ResponseDto rDto=new ResponseDto();
		log.info("entity={}",entity);
		System.out.println("2"+repo.getQuestionCount(entity.getQuizId()));
		System.out.println("22"+entity.getQuestionNumber());
		if(repo.findByQuestionId(entity.getQuestionId()).isPresent())
		{
			System.out.println("1");
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.QUESTION_ADDED_FAILED);
		}
		else if(repo.checkIsQuestionExist(entity.getQuizName(), entity.getQuizType(), entity.getQuestion()).isEmpty()==false)
		{
			System.out.println("11");
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.QUESTION_ALREADY_EXIST);
		}
		else if(! (repo.getQuestionCount(entity.getQuizId())>=entity.getQuestionNumber()))
		{
			System.out.println("111");
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.QUESTIONS_ADDED_LIMIT_IS_COMPLETED);
		}
		else
		{
			System.out.println("1111");
			log.info("result ={}", repo.save(entity));
			rDto.setMessage(Constants.QUESTION_ADDED_SUCCESS);
		}
		return rDto;
	}
	@Override
	public List<Question> showAllQuestions() {
		return repo.findAll();
	}

	@Override
	public Optional<Question> showQuestionById(Integer eid) {
		return repo.findById(eid);
	}
	public Integer getQuestionCount(Integer qid) {
		// TODO Auto-generated method stub
		return repo.getQuestionCount(qid);
	}
	public Integer qExactCount(Integer id) {
		// TODO Auto-generated method stub
		return repo.qExactCount(id);
	}
}
