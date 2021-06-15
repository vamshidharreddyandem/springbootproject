package com.memorystack.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Student;
import com.memorystack.repositories.StudentRepo;
import com.memorystack.service.IStudentService;
@Service
public class StudentServiceImpl implements IStudentService {

	protected static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	public StudentRepo repo;
	@Override
	public List<Student> showAllStudents() {
		return repo.findAll();
	}
	@Override
	public ResponseDto saveStudent(Student entity) 
	{
		ResponseDto rDto=new ResponseDto();
		log.info("entity={}",entity);
		if(repo.findByUserName(entity.getUserName()).isPresent())
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.STUDENT_REG_FAILED);
		}
		else 
		{
			log.info("result ={}", repo.save(entity));
			rDto.setMessage(Constants.STUDENT_REG_SUCCESS);
		}
		return rDto;
	}
	public ResponseDto studentLoginCheck(String id,String password)
	{
		ResponseDto rDto=new ResponseDto();
		if(repo.findByEmailAndPassword(id, password).isPresent())
		{
			rDto.setMessage(Constants.STUDENT_LOGIN_SUCCESS);
		}
		else
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.STUDENT_LOGIN_FAILED);
		}
		return rDto;
	}
	public Optional<Student> showStudentById(Long id) {
		return repo.findById(id);
	}
	@Override
	public Optional<Student> showStudentByUserName(String userName) {
		// TODO Auto-generated method stub
		return repo.findByUserName(userName);
	}
	public Student showStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmailId(email);
	}
}
