package com.memorystack.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.dto.ApiResponse;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Admin;
import com.memorystack.service.impl.AdminServiceImpl;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AdminRestController {
protected static Logger log = LoggerFactory.getLogger(AdminRestController.class);
	
	@Autowired
	public AdminServiceImpl adminService;
		
	@PostMapping(path = "/saveadmin", consumes = "application/json", produces = "application/json")    
    public ResponseEntity<?> createAmin( @RequestBody Admin admin)
    {
		ResponseDto status=adminService.saveAdmin(admin);
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }
	
	@GetMapping("/showalladmins")
	public List<Admin> retrieveAllStudents() {
		return adminService.showAllAdmins();
	}
	
	@PostMapping(path="/loginadmin", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin admin) 
	{
		ResponseDto status= adminService.adminLoginCheck(admin.getAdminId(),admin.getPassword());
		log.info("status ={}",status.getStatus());
		return ResponseEntity
				.status(status.getStatus()?HttpStatus.OK:HttpStatus.NON_AUTHORITATIVE_INFORMATION)
				.body(status.getStatus()?new ApiResponse(true, status.getMessage()):new ApiResponse(status.getStatus(),status.getMessage()));
    }}
