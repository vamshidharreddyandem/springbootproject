package com.memorystack.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.memorystack.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Serializable> {
	Optional<Question> findByQuestionId(Integer questionId);
	
	@Query(value ="select * from stack.questions  where quizname =?1 and quiztype =?2 and question =?3",nativeQuery =true)
    List<Question> checkIsQuestionExist(String quizName,String quizType,String question);
	
	@Query(value ="select  questioncount from stack.quiz where quizid =?1",nativeQuery =true)
    Integer getQuestionCount(Integer quizid);

	@Query(value="select * from stack.questions where quizid=?1",nativeQuery = true)
	List<Question> getQuizData(String quizid);

	@Query(value="select count(quizid) from stack.questions where quizid=?1",nativeQuery = true)
	Integer qExactCount(Integer quizid);
}
