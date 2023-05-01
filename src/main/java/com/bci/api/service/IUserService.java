package com.bci.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseAllDto;
import com.bci.api.dto.UserResponseDto;

public interface IUserService {

	public UserResponseDto save(UserRequestDto user);

	public List<UserResponseAllDto> findAll();

	public void deleteById(UUID id);

	public Optional<UserResponseAllDto> findById(UUID uuid);

}
