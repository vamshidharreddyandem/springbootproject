package com.memorystack.controllers;

import java.util.List;
import java.util.NoSuchElementException;
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
import com.memorystack.model.Question;
import com.memorystack.model.Quiz;
import com.memorystack.model.Student;
import com.memorystack.service.impl.QuizServiceImpl;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class QuizRestController {
protected static Logger log = LoggerFactory.getLogger(QuizRestController.class);
	
	@Autowired
	public QuizServiceImpl quizService;
	
	@PostMapping(path = "/quiz", consumes = "application/json", produces = "application/json")    
    public ResponseEntity<?> createQuiz( @RequestBody Quiz quiz)
    {
		ResponseDto status=quizService.saveQuiz(quiz);
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }

	@GetMapping("/quizs")
	@ResponseBody
	public List<Quiz> readAllQuizs()
	{
		return quizService.showAllQuizs();
	}
	
	@GetMapping("/quizs/{quizid}")
	@ResponseBody
	public ResponseEntity<?>  retrieveStudent(@PathVariable String quizid) 
	{
		Optional<Quiz> q = quizService.showQuizById(Integer.parseInt(quizid));
		if(q.isPresent())
			return ResponseEntity.ok(q.get());
		else
		{
			ResponseDto dto=new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.QUIZ_ID_NOT_EXIST_CODE);
			dto.setMessage(Constants.QUIZ_ID_NOT_EXIST_MESSAGE);
			return ResponseEntity.ok(dto);
		}
	}
	
	@GetMapping("/quizData/{quizid}")
	@ResponseBody
	public List<Question>  getQuizData(@PathVariable String quizid) 
	{
			 List<Question> quizData = quizService.getQuizData(quizid);
		        return quizData;
		    
	}
	
	@GetMapping("/getQuizList/{subjectname}")
	@ResponseBody
	public List<Quiz> getQuizList(@PathVariable String subjectname){
		
		List<Quiz> quizList = quizService.getQuizList(subjectname);
		return quizList;
		
	}
	
}
