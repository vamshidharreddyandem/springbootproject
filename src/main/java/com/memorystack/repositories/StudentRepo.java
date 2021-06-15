package com.memorystack.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.memorystack.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Serializable> {
    Optional<Student> findByEmail(String email);

    Optional<Student> findByUserNameOrEmail(String username, String email);

    List<Student> findByUserIdIn(List<Long> userIds);

    Optional<Student> findByUserName(String username);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);
    

    @Transactional
    @Modifying
    @Query("UPDATE Student a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
    
	Optional<Student> findByEmailAndPassword(String email,String password);
	
	@Query("from Student a where a.email=?1")
	Student findByEmailId(String email);
}
