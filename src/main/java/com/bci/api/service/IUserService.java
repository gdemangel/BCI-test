package com.bci.api.service;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;


public interface IUserService {
	
	UserResponseDto save(UserRequestDto user);
}
