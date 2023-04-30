package com.bci.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.UserEntity;
import com.bci.api.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api")
@CrossOrigin("*")
@Valid
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "/create", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser( @Valid @RequestBody UserRequestDto user) {

		UserResponseDto u = userService.save(user);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}
}
