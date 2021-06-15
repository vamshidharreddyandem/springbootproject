package com.memorystack.controllers;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memorystack.dto.PasswordRequestDto;
import com.memorystack.dto.ResponseDto;
import com.memorystack.model.Student;
import com.memorystack.payload.ApiResponse;
import com.memorystack.payload.LoginRequest;
import com.memorystack.payload.SignUpRequest;
import com.memorystack.repositories.RoleRepository;
import com.memorystack.repositories.StudentRepo;
import com.memorystack.security.JwtTokenProvider;
import com.memorystack.service.impl.RegistrationService;
import com.memorystack.service.impl.StudentServiceImpl;
import com.memorystack.service.impl.UserServiceImpl;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class UserMangAuthController {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentRepo userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    private RegistrationService registrationService;
    
    
    @Autowired
    StudentServiceImpl studentServiceImpl;
    
    
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    	log.info(" inside sign in==="+loginRequest.getUsernameOrEmail()+" loginRequest.getPassword()=="+loginRequest.getPassword());
    	Authentication authentication=null;
    	try{
    		authentication= authenticationManager.authenticate(
    				new UsernamePasswordAuthenticationToken(
    						loginRequest.getUsernameOrEmail(),
    						loginRequest.getPassword()
    						));
    	}
    	catch(BadCredentialsException b){
    		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Bad credentials!"),
                    HttpStatus.UNAUTHORIZED);
    	}
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
    	log.info("Leaving authenticateUser with token value=="+jwt);
       //todo need to move to API gateway
    	
    	//prudhvi code
    	try {
	    	Student student = studentServiceImpl.showStudentByEmail(loginRequest.getUsernameOrEmail());
	        return new ResponseEntity<Student>(student,HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	    }
       //return  ResponseEntity.ok().header("Access-Control-Expose-Headers","*").body("success");
    }

   
    
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/register")  
    public ResponseEntity<?> userRegister( @RequestBody SignUpRequest registrationRequest) 
    {
		log.info("userRegister ={}",registrationRequest.getEmail());
		ResponseDto statusDto=registrationService.registerS(registrationRequest);
		log.debug("statusDto userRegister ={}",statusDto.getStatus());
		return ResponseEntity.status(statusDto.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY).
				body(statusDto.getStatus()?
				new ApiResponse(true, statusDto.getMessage()):
					new ApiResponse(statusDto.getStatus(), statusDto.getMessage()));
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/confirm")  
    public ResponseEntity<?> userRegisterConfirmPassword(@RequestBody PasswordRequestDto registrationRequest) 
    {
		log.info("userRegisterConfirmPassword ={}",registrationRequest.getToken());
		String token="token";
		ResponseDto statusDto=registrationService.confirmTokenS(token,registrationRequest);
		log.debug("statusDto userRegister ={}",statusDto.getStatus());
		return ResponseEntity.status(statusDto.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY).
				body(statusDto.getStatus()?
				new ApiResponse(true, statusDto.getMessage()):
					new ApiResponse(statusDto.getStatus(), statusDto.getMessage()));
    }
    
    
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/forgot-password")  
    public ResponseEntity<?> userForgotPassword(@RequestBody Student user) 
    {
		log.info("userForgotPassword ={}",user.getEmail());
		ResponseDto statusDto=registrationService.forgotUserPassword(user);
		log.debug("statusDto userForgotPassword ={}",statusDto.getStatus());
		return ResponseEntity.status(statusDto.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY).
				body(statusDto.getStatus()?
				new ApiResponse(true, statusDto.getMessage()):
					new ApiResponse(statusDto.getStatus(), statusDto.getMessage()));
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json", path = "/confirm-forgot-password")  
    public ResponseEntity<?> confirmUserForgotPassword(@RequestBody PasswordRequestDto registrationRequest) 
    {
		log.info("userRegisterConfirmPassword ={}",registrationRequest.getToken());
		String token="token";
		ResponseDto statusDto=registrationService.confirmForgotUserPassword(token,registrationRequest);
		log.debug("statusDto userRegister ={}",statusDto.getStatus());
		return ResponseEntity.status(statusDto.getStatus()?HttpStatus.OK:HttpStatus.UNPROCESSABLE_ENTITY).
				body(statusDto.getStatus()?
				new ApiResponse(true, statusDto.getMessage()):
					new ApiResponse(statusDto.getStatus(), statusDto.getMessage()));
    }
    
  
    
    @PostMapping("/register1")
    public String register(@RequestBody SignUpRequest registrationRequest) {
		System.out.println("----------------------request>::"+registrationRequest.toString());
		log.info("register ={}",registrationRequest.getEmail());
        return registrationService.register(registrationRequest);
    }

    @PostMapping(path = "confirm1")
    //public String confirm(@RequestParam("token") String token,@RequestBody PasswordRequestDto registrationRequest) {
    public String confirm(@RequestBody PasswordRequestDto registrationRequest) {
    	log.info("register ={}",registrationRequest.getToken());
    	String token="token";
    	return registrationService.confirmToken(token,registrationRequest);
    }
    
    
}
