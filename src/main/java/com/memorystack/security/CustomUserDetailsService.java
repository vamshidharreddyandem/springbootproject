package com.memorystack.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memorystack.exceptions.ResourceNotFoundException;
import com.memorystack.model.Student;
import com.memorystack.repositories.StudentRepo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRepo userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
    	System.out.println(" inside CustomUserDetailsService user name is== "+usernameOrEmail);
        // Let people login with either username or email
        Student user = userRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );
System.out.println("loadUserByUsername user :"+user.toString());
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Student user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}