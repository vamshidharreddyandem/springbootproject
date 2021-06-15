package com.memorystack.service;

import java.util.List;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Admin;

public interface IAdminService {
	ResponseDto saveAdmin(Admin entity);
	List<Admin> showAllAdmins() ;

}
