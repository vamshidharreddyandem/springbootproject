package com.memorystack.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Job;
import com.memorystack.repositories.JobRepo;
import com.memorystack.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	protected static Logger log = LoggerFactory.getLogger(JobServiceImpl.class);

	@Autowired
	public JobRepo jobRepo;

	@Override
	public ResponseDto saveJob(Job entity) {
		ResponseDto dto = new ResponseDto();
		log.info("entity={}", entity);
		if (entity.getTitle() == null) {
			dto.setStatus(Boolean.FALSE);
			dto.setMessage(Constants.JOB_ADDED_FAILED);
		} else {
			log.info("result={}", jobRepo.save(entity));
			dto.setMessage(Constants.JOB_ADDED_SUCCESS);
		}
		return dto;
	}

	@Override
	public List<Job> showAllJobs() {
		return jobRepo.findAll();
	}

	@Override
	public Optional<Job> findJobById(Integer id) {
		return jobRepo.findById(id);
	}

	@Override
	public void removeJobById(Integer id) {
		jobRepo.deleteById(id);
	}

	@Override
	public Job updateJobById(Integer jobId, Job entity) {
		jobRepo.updateJobById(entity.getTitle(), entity.getLocation(), entity.getPayrate(), entity.getDiscription(),
				jobId);
		return entity;
	}

}
