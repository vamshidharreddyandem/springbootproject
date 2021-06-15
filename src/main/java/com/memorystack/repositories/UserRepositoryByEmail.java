package com.memorystack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memorystack.model.Student;


@Repository
public interface UserRepositoryByEmail extends JpaRepository<Student, Long>{
	
	Student findByEmail(String confirmationToken);

}
