package com.memorystack.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.model.Student;
import com.memorystack.service.impl.UserServiceImpl;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserListController {

	@Autowired
	UserServiceImpl userServiceImpl;

	
	@GetMapping(value = "/api/auth/users", produces = "application/json")
	public List<Student> userList() {
		List<Student> users = userServiceImpl.findUserList();
		return users;
	}

	@GetMapping("/api/auth/user/{userid}")
	public ResponseEntity<Student> getUser(@PathVariable(value = "userid") Long id) {
	    try {
	    	Student product = userServiceImpl.findById(id);
	        return new ResponseEntity<Student>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PutMapping("/api/auth/updateuser")
	public ResponseEntity<Student> updateUser(@RequestBody Student reqJson) {

		Student user = userServiceImpl.updateUser(reqJson);

		return ResponseEntity.ok().body(user);
	}
	
}