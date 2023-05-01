package com.bci.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseAllDto;
import com.bci.api.dto.UserResponseDto;

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
	public ResponseEntity<UserResponseDto> createUser(
			@Valid @RequestBody UserRequestDto user) {

		UserResponseDto u = userService.save(user);
		return ResponseEntity.created(URI.create("/vi/api" + u.getUser_id())).body(u);
	}

	@GetMapping(value = "getAll", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserResponseAllDto>> findAll() {

		return ResponseEntity.ok().body(userService.findAll());

	}

	@DeleteMapping(value = "deleteUser/{uuid}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDto> deleteUser(
			@PathVariable(value = "uuid") UUID uuid) {

		userService.deleteById(uuid);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/getUser/{uuid}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<UserResponseAllDto>> findUser(
			@PathVariable(value = "uuid") UUID uuid) {
		
		Optional<UserResponseAllDto> result = userService.findById(uuid);
		
		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok().body(result);
	}

}
