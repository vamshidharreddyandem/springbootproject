package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Subject;



public interface ISubjectService {
	ResponseDto saveSubject(Subject entity);
	List<Subject> showAllSubjects();
	Optional<Subject> showSubjectById(String sid);
}
