package com.bci.api.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.api.dto.UserMapper;
import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.UserEntity;
import com.bci.api.entity.PhoneEntity;
import com.bci.api.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public UserResponseDto save(UserRequestDto user) {
		
		List<?> phone = new ArrayList<>();	
		
		UserEntity us =  userMapper.toModel(user);	
		
		return userMapper.toDto(userRepository.save(us));
	}
}
