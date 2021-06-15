package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Student;



public interface IStudentService {
	ResponseDto saveStudent(Student entity);
	List<Student> showAllStudents();
	Optional<Student> showStudentByUserName(String userName);
	ResponseDto studentLoginCheck(String email,String password);
	
}
