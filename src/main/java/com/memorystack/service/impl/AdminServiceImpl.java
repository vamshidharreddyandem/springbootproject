package com.memorystack.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memorystack.contants.Constants;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Admin;
import com.memorystack.repositories.AdminRepo;
import com.memorystack.repositories.SubjectRepo;
import com.memorystack.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService 
{
	protected static Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	public AdminRepo adminRepo;
	
	public SubjectRepo subjectRepo;
	
	public ResponseDto saveAdmin(Admin entity) 
	{
		ResponseDto rDto=new ResponseDto();
		log.info("Save admin entity={}",entity);
		if(adminRepo.findByAdminId(entity.getAdminId()).isPresent())
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.ADMIN_REG_FAILED);
		}
		else 
		{
			log.info("Save admin result ={}", adminRepo.save(entity));
			rDto.setMessage(Constants.ADMIN_REG_SUCCESS);
		}
		return rDto;
	}

	public List<Admin> showAllAdmins() {
		return adminRepo.findAll();
	}
	
	public ResponseDto adminLoginCheck(String adminId,String password)
	{
		ResponseDto rDto=new ResponseDto();
		if(adminRepo.findByAdminIdAndPassword(adminId, password).isPresent())
		{
			rDto.setMessage(Constants.ADMIN_LOGIN_SUCCESS);
		}
		else
		{
			rDto.setStatus(Boolean.FALSE);
			rDto.setMessage(Constants.ADMIN_LOGIN_FAILED);
		}
		return rDto;
	}
	
}
