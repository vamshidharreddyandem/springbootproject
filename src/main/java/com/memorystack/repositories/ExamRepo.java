package com.memorystack.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memorystack.model.Exam;

public interface ExamRepo extends JpaRepository<Exam, Serializable> {

}
