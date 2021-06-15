package com.memorystack.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ApiResponse;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Student;
import com.memorystack.service.impl.StudentServiceImpl;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentRestController {
protected static Logger log = LoggerFactory.getLogger(StudentRestController.class);
	
	@Autowired
	public StudentServiceImpl studentService;
	
//	@PostMapping(path = "/student", consumes = "application/json", produces = "application/json")    
//    public ResponseEntity<?> createStudent( @RequestBody Student student)
//    {
//		ResponseDto status=studentService.saveStudent(student);
//		log.info("status ={}",status.getStatus());
//		return ResponseEntity
//				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
//				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
//    }
//	@GetMapping("/students")
//	@ResponseBody
//	public List<Student> retrieveAllStudents() {
//		return studentService.showAllStudents();
//	}
	
//	@PostMapping(path="/loginstudent", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<?> loginAdmin(@RequestBody Student student) 
//	{
//		ResponseDto status= studentService.studentLoginCheck(student.getStudentUserId(),student.getPassword());
//		log.info("status ={}",status.getStatus());
//		return ResponseEntity
//				.status(status.getStatus()?HttpStatus.OK:HttpStatus.NON_AUTHORITATIVE_INFORMATION)
//				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
//    }
    
//	@GetMapping("/students/{id}")
//	@ResponseBody
//	public ResponseEntity<?>  retrieveStudent(@PathVariable String id) 
//	{
//		Optional<Student> q = studentService.showStudentById(id);
//		if(q.isPresent())
//			return ResponseEntity.ok(q.get());
//		else
//		{
//			ResponseDto dto=new ResponseDto();
//			dto.setStatus(true);
//			dto.setErrorCode(Constants.STUDENT_ID_NOT_EXIST_CODE);
//			dto.setMessage(Constants.STUDENT_ID_NOT_EXIST_MESSAGE);
//			return ResponseEntity.ok(dto);
//		}
//	}
}
