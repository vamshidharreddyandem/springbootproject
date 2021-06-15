package com.memorystack.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.memorystack.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Serializable> {

	Optional<Job> findByTitle(String title);

	@Transactional
	@Modifying
	@Query(value="UPDATE job  SET title = ?1, location = ?2, payrate = ?3, discription = ?4 WHERE id = ?5",nativeQuery = true)
	Integer updateJobById(String title, String location, Integer payrate, String discription, Integer id);

}
