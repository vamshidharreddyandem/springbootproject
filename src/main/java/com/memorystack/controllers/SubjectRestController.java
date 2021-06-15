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
import com.memorystack.model.RegisteredSubjects;
import com.memorystack.model.Subject;
import com.memorystack.repositories.RegisteredSubjectRepo;
import com.memorystack.service.impl.SubjectServiceImpl;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class SubjectRestController 
{
	protected static Logger log = LoggerFactory.getLogger(SubjectRestController.class);

	@Autowired
	public SubjectServiceImpl subjectService;

	@GetMapping("/subjects")
	@ResponseBody
	public List<Subject> readAllSubjects()
	{
		return subjectService.showAllSubjects();
	}
	
	@GetMapping("/getRegisteredCourses/{userId}")
	@ResponseBody
	public List<?> getRegisteredCourses(@PathVariable String userId){
		System.out.println("in get regioster ");
		System.out.println(userId);
		System.out.println(Integer.parseInt(userId));
		//return subjectService.getRegisteredSubjects(Integer.parseInt(userId));
		
		return subjectService.getRegisteredSubjects(Integer.parseInt(userId));
	}

	@GetMapping("/subjects/{name}")
	@ResponseBody
	public ResponseEntity<?> retrieveSubject(@PathVariable String name) 
	{
		Optional<Subject> q = subjectService.showSubjectById(name);
		if(q.isPresent())
			return ResponseEntity.ok(q.get());
		else
		{
			ResponseDto dto=new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.SUBJECT_NOT_EXIST_CODE);
			dto.setMessage(Constants.SUBJECT_NOT_EXIST_MESSAGE);
			return ResponseEntity.ok(dto);
		}
	}
	@PostMapping(path = "/savesubject", consumes = "application/json", produces = "application/json")    
    public ResponseEntity<?> savesubject( @RequestBody Subject subject)
    {
		ResponseDto status=subjectService.saveSubject(subject);
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }
	
	@PostMapping(path = "/registerSubject", consumes = "application/json", produces = "application/json")    
    public ResponseEntity<?> registerSubject( @RequestBody RegisteredSubjects rSubject)
    {
		ResponseDto status=subjectService.registerSubject(rSubject);
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }
}
