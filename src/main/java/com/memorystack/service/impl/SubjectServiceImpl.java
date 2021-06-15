package com.memorystack.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.RegisteredSubjects;
import com.memorystack.model.Subject;
import com.memorystack.repositories.RegisteredSubjectRepo;
import com.memorystack.repositories.SubjectRepo;
import com.memorystack.service.ISubjectService;
@Service
public class SubjectServiceImpl implements ISubjectService {
	protected static Logger log = LoggerFactory.getLogger(SubjectServiceImpl.class);
	@Autowired
	public SubjectRepo subjectRepo;
	@Autowired
	public RegisteredSubjectRepo rSubjectRepo;
	@Override
	public ResponseDto saveSubject(Subject entity) 
	{
		ResponseDto rDto=new ResponseDto();
		log.info("entity={}",entity);
		if(subjectRepo.findBySubjectName(entity.getSubjectName()).isPresent())
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.SUBJECT_ADDED_FAILED);
		}
		else
		{
			log.info("result ={}", subjectRepo.save(entity));
			rDto.setMessage(Constants.SUBJECT_ADDED_SUCCESS);
		}
		return rDto;
	}

	@Override
	public List<Subject> showAllSubjects() {
		return subjectRepo.findAll();
	}

	@Override
	public Optional<Subject> showSubjectById(String id) {
		return subjectRepo.findById(id);
	}

	public ResponseDto registerSubject(RegisteredSubjects rSubject) {
		ResponseDto rDto=new ResponseDto();
		log.info("entity={}",rSubject);
		if(rSubjectRepo.findBySubjectname(rSubject.getSubjectname(),rSubject.getUserId()).isPresent())
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.COURSE_REGISTERED_FAILED);
		}
		else
		{
			log.info("result ={}", rSubjectRepo.save(rSubject));
			rDto.setMessage(Constants.COURSE_REGISTERED_SUCCESS);
		}
		return rDto;
	}

	public List<?> getRegisteredSubjects(int parseInt) {
		// TODO Auto-generated method stub
		return rSubjectRepo.getRegisteredSubjects(parseInt);
	}
	
}
