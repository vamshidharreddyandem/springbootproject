package com.memorystack.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.memorystack.model.RegisteredSubjects;
import com.memorystack.model.Subject;

@Repository
public interface RegisteredSubjectRepo extends JpaRepository<RegisteredSubjects, Serializable>  {

	@Query("from RegisteredSubjects r where r.userId=?1")
	List<?> getRegisteredSubjects(int userid);


	@Query("from RegisteredSubjects r where r.subjectname=?1 and r.userId=?2")
	Optional<Subject> findBySubjectname(String subjectname, int userId);
}
