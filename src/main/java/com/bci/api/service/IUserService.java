package com.bci.api.service;

import java.util.List;
import java.util.UUID;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseAllDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.UserEntity;

public interface IUserService {

	UserResponseDto save(UserRequestDto user);

	List<UserResponseAllDto> findAll();

	void deleteById(UUID id);

	UserResponseAllDto findById(UUID uuid);
	
	UserEntity findByIdUpdate(UUID uuid);
	
	UserResponseDto update(UserRequestDto userRequestDto , UUID uuid);



}
