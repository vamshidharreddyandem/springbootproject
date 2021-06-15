package com.memorystack.service;

import java.util.List;

import com.memorystack.model.Student;

public interface UserService {
	
	List<Student> findUserList();
	Student findById(Long id);
	
	Student updateUser(Student user);
	
	Integer deleteUserById(Long id);
	
	
	
	

}
