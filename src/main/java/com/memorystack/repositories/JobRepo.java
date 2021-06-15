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
	@Query("UPDATE job j SET j.title = ?1, j.location = ?2, j.payrate = ?3, j.discription = ?4 WHERE j.id = ?5")
	int updateJobById(String title, String location, Integer payrate, String discription, Integer id);

}
