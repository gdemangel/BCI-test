package com.bci.api.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.api.dto.UserMapper;
import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseAllDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.UserEntity;
import com.bci.api.repository.IUserRepository;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserResponseDto save(UserRequestDto user) {		
		
		UserEntity us =  userMapper.toModel(user);	
		
		return userMapper.toDto(userRepository.save(us));
	}

	@Override
	public List<UserResponseAllDto> findAll() {
		
		List<UserEntity> users = userRepository.findAll();
		
		List<UserResponseAllDto> userDto = new ArrayList<>();
		for(UserEntity user: users) {
			userDto.add(userMapper.toAllDto(user));
		}
		
		return userDto;
	}

	@Override
	public void deleteById(UUID id) {
		userRepository.deleteById(id);// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<UserResponseAllDto> findById(UUID uuid) {
		
		return userRepository.findById(uuid).map(userMapper::toAllDto);		
	
	}

	
	
}
