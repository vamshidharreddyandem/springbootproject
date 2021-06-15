package com.memorystack.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.memorystack.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Serializable> {

	Optional<Quiz> findByQuizId(Integer quizId);
	
	@Query(value ="select quizname from stack.quiz where adminid =?1 and subjectname=?2 and quizname=?3 and quiztype=?4",nativeQuery =true)
    String checkIsQuizExist(String adminid,String subjectname,String quizName,String quizType);
	
	@Query(value ="SELECT count(*) FROM stack.quiz WHERE quiztype IN ('EASY', 'MEDIUM', 'HARD')",nativeQuery =true)
	Integer checkValidQuizType();

	@Query(value = "SELECT * FROM stack.quiz WHERE subjectname =?1", nativeQuery =true)
	List<Quiz> getQuizList(String subjectname);
	
	//List<Student> findByQuizIdAdminIdAndSubjectName(Integer quizid,String adminid,String subjectname);
}
