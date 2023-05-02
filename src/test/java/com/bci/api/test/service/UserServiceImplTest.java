package com.bci.api.test.service;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bci.api.service.UserServiceImpl;
import com.bci.api.repository.IUserRepository;
import com.bci.api.dto.UserMapper;
import com.bci.api.test.util.UserUtil;

import jakarta.persistence.EntityNotFoundException;

import com.bci.api.entity.UserEntity;
import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Mock
	private IUserRepository iUserRepository;
	
	@Spy
	private UserMapper userMapper;

	private UserUtil util = new UserUtil();

	@Test
	public void test_Create_Should_CreatedUser_When_Invoked() {
		
		Mockito.when(iUserRepository.save(Mockito.any(UserEntity.class))).thenAnswer(p -> util.creatModel((UserEntity) p.getArguments()[0]));
		Mockito.when(userMapper.toDto(Mockito.any(UserEntity.class))).thenAnswer(p -> util.toDto((UserEntity) p.getArguments()[0]));
		Mockito.when(userMapper.toModel(Mockito.any(UserRequestDto.class))).thenAnswer(p -> util.toModel((UserRequestDto) p.getArguments()[0]));
		UserRequestDto userRequestDto = util.createUserRequestDto();
		UserResponseDto userResponseDto = userServiceImpl.save(userRequestDto);

		Assertions.assertNotNull(userResponseDto);
		Assertions.assertNotNull(userResponseDto.getUserId());

		Mockito.verify(iUserRepository, Mockito.times(1)).save(Mockito.any());
		Mockito.verify(userMapper, Mockito.times(1)).toDto(Mockito.any());
		Mockito.verify(userMapper, Mockito.times(1)).toModel(Mockito.any());
	}
	
	
	
	@Test
	public void test_Show_Should_ReturnEntityNotFoundException_When_Invoked() {
		Mockito.when(iUserRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.empty());

		EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class, () -> {
			userServiceImpl.findById(UUID.randomUUID());
		});

		Assertions.assertNotNull(exception);
		Assertions.assertNotNull(exception.getMessage());

		Mockito.verify(iUserRepository, Mockito.times(1)).findById(Mockito.any(UUID.class));

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
