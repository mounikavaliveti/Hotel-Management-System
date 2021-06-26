package com.hotel.Security.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Security.entity.User;
import com.hotel.Security.payload.request.LoginRequest;
import com.hotel.Security.payload.request.SignupRequest;
import com.hotel.Security.payload.response.MessageResponse;
import com.hotel.Security.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	UserRepository userRepository;

	 @GetMapping(value = "/test/Api")
	    public String testHm() {


	        return "Welcome!!";
	    }
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		 Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
	                
		
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmpId(signUpRequest.getEmpId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmpId(),
							 signUpRequest.getPassword(),signUpRequest.getRole());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
