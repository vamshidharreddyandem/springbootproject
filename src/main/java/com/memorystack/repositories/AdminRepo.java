package com.memorystack.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memorystack.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Serializable> {

	Optional<Admin> findByAdminId(String adminId);
	Optional<Admin> findByAdminIdAndPassword(String adminId,String password);
}
