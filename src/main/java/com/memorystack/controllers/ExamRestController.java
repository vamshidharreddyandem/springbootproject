package com.memorystack.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.dto.ExamInfo;
import com.memorystack.dto.ExamResultInfo;
import com.memorystack.model.Exam;
import com.memorystack.service.impl.ExamServiceImpl;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ExamRestController {
	protected static Logger log = LoggerFactory.getLogger(ExamRestController.class);

	@Autowired
	public ExamServiceImpl examService;
	
	@PostMapping(path = "/starttest",consumes = "application/json", produces = "application/json")  
	@ResponseBody
	public ResponseEntity<ExamResultInfo> examReport( @RequestBody ExamInfo examInfo)
	{
		log.info("examInfo ={}",examInfo);
		ExamResultInfo finalResult = examService.getFinalResult(examInfo);
		log.info("finalResult ={}",finalResult);
		return ResponseEntity.ok(finalResult);
	}

	@GetMapping("/allexams")
	@ResponseBody
	public List<Exam> readAllProducts()
	{
		return examService.showAllExams();
	}
	@GetMapping("/allexams/{id}")
	public Exam retrieveStudent(@PathVariable String id) {
		Optional<Exam> exam = examService.showExamById(id);
		return exam.get();
	}
}
