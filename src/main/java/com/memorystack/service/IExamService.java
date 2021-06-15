package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.model.Exam;

public interface IExamService {
	Exam saveExam(Exam entity);
	List<Exam> showAllExams();
	Optional<Exam> showExamById(String eid);
}
