package com.memorystack.service;

import java.util.List;
import java.util.Optional;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Job;

public interface JobService {

	List<Job> showAllJobs();

	Optional<Job> findJobById(Integer id);

	Job updateJobById(Integer jobId, Job entity);

	void removeJobById(Integer id);

	ResponseDto saveJob(Job entity);

}
