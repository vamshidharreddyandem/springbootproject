package com.memorystack.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memorystack.model.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Serializable> {
	Optional<Subject> findBySubjectName(String name);
}
