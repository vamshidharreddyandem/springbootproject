package com.memorystack.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.dto.ExamDto;
import com.memorystack.dto.ExamInfo;
import com.memorystack.dto.ExamResultDto;
import com.memorystack.dto.ExamResultInfo;
import com.memorystack.model.Exam;
import com.memorystack.model.Question;
import com.memorystack.repositories.ExamRepo;
import com.memorystack.repositories.QuestionRepo;
import com.memorystack.service.IExamService;
@Service
public class ExamServiceImpl implements IExamService {

	protected static Logger log = LoggerFactory.getLogger(ExamServiceImpl.class);
	@Autowired
	public ExamRepo repo;
	
	@Autowired
	public QuestionRepo questionsRepo;


	@Override
	public Exam saveExam(Exam entity) {
		return repo.save(entity);
	}

	@Override
	public List<Exam> showAllExams() {
		return repo.findAll();
	}

	@Override
	public Optional<Exam> showExamById(String eid) {
		return repo.findById(eid);
	}
	
	public ExamResultInfo getFinalResult(ExamInfo examInfo)	{
		log.info("examInfo="+examInfo);
		ExamResultInfo finalResponse=new ExamResultInfo();
		List<Question> allDbQuestions = questionsRepo.getQuizData(examInfo.getQuizid());
		List<ExamDto> postmanQuestions = examInfo.getQuestions();
		System.out.println("-----DB----------");
		allDbQuestions.forEach(x->{
			System.out.println("qno"+x.getQuestionNumber()+",ans="+x.getAns());
		});
		postmanQuestions.forEach(x->{
			System.out.println("qno"+x.getQuestionNumber()+",option="+x.getOption());
		});
		int count=0,questionCount=0;
		Iterator<Question> iterator1 = allDbQuestions.iterator();
		Iterator<ExamDto> iterator2 = postmanQuestions.iterator();
		List<ExamResultDto> ans=new ArrayList<ExamResultDto>();
		while(iterator1.hasNext() && iterator2.hasNext()){
			log.info("---inside while---");
			questionCount++;
			ExamResultDto dto =new ExamResultDto();
			Question q1=iterator1.next();
			ExamDto q2=iterator2.next();
			dto.setQuestionNumber(q1.getQuestionNumber());
			dto.setQuestion(q1.getQuestion());
			dto.setAnswer(q1.getAns());
			dto.setYourAnswer(q2.getOption());
			dto.setOpt1(q1.getOpt1());
			dto.setOpt2(q1.getOpt2());
			dto.setOpt3(q1.getOpt3());
			dto.setOpt4(q1.getOpt4());
			if(q1.getAns().equalsIgnoreCase(q2.getOption())){
				count++;
				dto.setStatus("CORRECT");
			}
			else{
				dto.setStatus("WRONG");
			}
			ans.add(dto);
		}
		System.out.println("----------\nCount="+count);
		System.out.println("----------\nQuestion Count="+questionCount);
		ans.forEach(x->{	System.out.println("x="+x);		});
		finalResponse.setStudentUserId(examInfo.getStudentUserId());
		finalResponse.setQuestionsAttempted(questionCount);
		finalResponse.setAnswerCount(count);
		finalResponse.setAnswerList(ans);
		return finalResponse;
	}
}
