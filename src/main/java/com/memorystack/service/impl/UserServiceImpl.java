package com.memorystack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.model.Student;
import com.memorystack.repositories.StudentRepo;
import com.memorystack.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private StudentRepo userRepository;

	@Override
	public List<Student> findUserList() {
		
		return userRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public Student updateUser(Student user) {
		
		return userRepository.save(user);
	}

	@Override
	public Integer deleteUserById(Long id) {
		
		return null;
	}
	
	

}
