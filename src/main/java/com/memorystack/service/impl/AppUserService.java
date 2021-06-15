package com.memorystack.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.memorystack.dto.ResponseDto;
import com.memorystack.model.ConfirmationToken;
import com.memorystack.model.Student;
import com.memorystack.repositories.StudentRepo;
import com.memorystack.utils.Constants;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG ="user with email %s not found";

    @Autowired
    private StudentRepo appUserRepository;
    //private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;


	@Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return (UserDetails) appUserRepository.findByEmail(email).orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(Student user) {
        boolean userExists = appUserRepository.findByEmail(user.getEmail()).isPresent();

        System.out.println("userExists------------>:"+userExists);
        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            throw new IllegalStateException(Constants.EMAIL_ALREADY_TAKEN);
        }
        appUserRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5),
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO : SEND EMAIL

        return token;
    }
    
    public ResponseDto signUpUserS(Student user) {
        boolean userExists = appUserRepository.findByEmail(user.getEmail()).isPresent();
        ResponseDto internalDto=new ResponseDto();
        System.out.println("userExists------------>:"+userExists);
        if (userExists) {
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.

            //throw new IllegalStateException(Constants.EMAIL_ALREADY_TAKEN);
            internalDto.setStatus(Boolean.FALSE);
			internalDto.setMessage(Constants.EMAIL_ALREADY_TAKEN); 
        }
        appUserRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(5),
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

        return internalDto;
    }
    
    public String conformUserPassword(Student appUser) {
        
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUser.setEnabled(Boolean.TRUE);
        appUser.setLocked(Boolean.TRUE);
        appUserRepository.save(appUser);

        return "password success";
    }
    
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
