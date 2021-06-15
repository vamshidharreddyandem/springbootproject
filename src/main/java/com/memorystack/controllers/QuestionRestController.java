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
import com.memorystack.model.Question;
import com.memorystack.service.impl.QuestionServiceImpl;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class QuestionRestController {
protected static Logger log = LoggerFactory.getLogger(QuestionRestController.class);
	
	@Autowired
	public QuestionServiceImpl questionService;
	
	@PostMapping(path = "/savequestion",consumes = "application/json", produces = "application/json")  
    public ResponseEntity<?> createQuestion( @RequestBody Question entity)
    {
		ResponseDto status=questionService.saveQuestion(entity);
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }
	
	@GetMapping("/questions")
	@ResponseBody
	public List<Question> readAllQuestion()
	{
		return questionService.showAllQuestions();
	}
	@GetMapping("/questions/{qid}")
	@ResponseBody
	public ResponseEntity<?> retrieveQuestion(@PathVariable String qid) {
		Optional<Question> q = questionService.showQuestionById(Integer.parseInt(qid));
		if(q.isPresent())
			return ResponseEntity.ok(q.get());
		else
		{
			ResponseDto dto=new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.QUESTION_ID_IS_FOUND_CODE);
			dto.setMessage(Constants.QUESTION_ID_NOT_EXIST_MESSAGE);
			return ResponseEntity.ok(dto);
		}
	}
	@GetMapping("/qCount/{qid}")
	@ResponseBody
	public Integer getQuestionCount(@PathVariable Integer qid) {
		return questionService.getQuestionCount(qid);
		
	}
	@GetMapping("/qExactCount/{id}")
	@ResponseBody
	public Integer getQCount(@PathVariable Integer id) {
		return questionService.qExactCount(id);
		
	}
}
