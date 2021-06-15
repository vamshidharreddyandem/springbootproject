package com.memorystack.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ApiResponse;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Job;
import com.memorystack.service.impl.JobServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class JobRestController {
	protected static Logger log = LoggerFactory.getLogger(JobRestController.class);

	@Autowired
	public JobServiceImpl jobServiceImpl;

	@PostMapping(path = "/job", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addJob(@RequestBody Job entity) {
		ResponseDto status = jobServiceImpl.saveJob(entity);
		log.info("status={}", status.getStatus());
		return ResponseEntity.status(status.getStatus() ? HttpStatus.OK : HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus() ? new ApiResponse(true, status.getMessage())
						: new ApiResponse(status.getStatus(), status.getMessage()));
	}

	@GetMapping("/jobs")
	@ResponseBody
	public List<Job> showAllJobs() {
		return jobServiceImpl.showAllJobs();
	}

	@GetMapping("/jobs/{jobid}")
	@ResponseBody
	public ResponseEntity<?> findJobById(@PathVariable String jobid) {
		Optional<Job> j = jobServiceImpl.findJobById(Integer.parseInt(jobid));
		if (j.isPresent())
			return ResponseEntity.ok(j.get());
		else {
			ResponseDto dto = new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.JOB_ID_DOESNT_EXIST);
			dto.setMessage(Constants.JOB_ID_DOESNT_EXIST);
			return ResponseEntity.ok(dto);
		}
	}
	
	@DeleteMapping("/job/delete/{jobid}")
	@ResponseBody
	public ResponseEntity<?> removeJobById(@PathVariable String jobid){
		Optional<Job> j = jobServiceImpl.findJobById(Integer.parseInt(jobid));
		if (j.isPresent()) {
			jobServiceImpl.removeJobById(Integer.parseInt(jobid));
			return ResponseEntity.ok(j.get());
		}
		else {
			ResponseDto dto = new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.JOB_ID_DOESNT_EXIST);
			dto.setMessage(Constants.JOB_ID_DOESNT_EXIST);
			return ResponseEntity.ok(dto);
		}
	}
	
	@PutMapping(path = "/job/update/{jobid}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateJob(@PathVariable String jobid, @RequestBody Job job){
		Optional<Job> j = jobServiceImpl.findJobById(Integer.parseInt(jobid));
		if (j.isPresent()) {
			job.setId(Integer.parseInt(jobid));
			job = jobServiceImpl.updateJobById(Integer.parseInt(jobid),job);
			return ResponseEntity.ok(job);
		}
		else {
			ResponseDto dto = new ResponseDto();
			dto.setStatus(true);
			dto.setErrorCode(Constants.JOB_ID_DOESNT_EXIST);
			dto.setMessage(Constants.JOB_ID_DOESNT_EXIST);
			return ResponseEntity.ok(dto);
		}
	}
}
