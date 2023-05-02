package com.bci.api.test.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.bci.api.dto.UserRequestDto;
import com.bci.api.dto.UserResponseDto;
import com.bci.api.entity.PhoneEntity;
import com.bci.api.entity.UserEntity;
import com.github.javafaker.Faker;

public class UserUtil {

	public Faker faker = new Faker();

	public List<PhoneEntity> phones = new ArrayList<>();

	public UserRequestDto createUserRequestDto() {

		return UserRequestDto.builder()
				.name(faker.name().fullName())
				.email(faker.expression("gonzalo.demange@bci.cl"))
				.password(faker.expression("123asdA!"))
				.phone(phones)
				.build();

	}

	public UserEntity createUser() {

		return UserEntity.builder()
				.userId(UUID.randomUUID())
				.name(faker.name().fullName())
				.email(faker.name().username())
				.creationDate(new Date())
				.lastUpdate(new Date())
				.lastLogin(new Date())
				.isActive(faker.number().randomDigit())
				.phone(phones)
				.accesToken(UUID.randomUUID()).build();
	}

	public UserEntity creatModel(UserEntity user) {

		user.setUserId(UUID.randomUUID());
		return user;

	}

	public UserResponseDto toDto(UserEntity user) {

		return UserResponseDto.builder()
				.userId(user.getUserId())
				.creationDate(user.getCreationDate())
				.lastUpdate(user.getLastUpdate())
				.lastLogin(user.getLastLogin())
				.isActive(user.getIsActive())
				.accesToken(user.getAccesToken())
				.build();

	}

	public UserEntity toModel(UserRequestDto user) {
		
		return UserEntity.builder()
				.userId(UUID.randomUUID())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.creationDate(new Date())
				.lastUpdate(new Date())
				.lastLogin(new Date())
				.isActive(faker.number().randomDigit())
				.phone(user.getPhone())
				.accesToken(UUID.randomUUID()).build();
	
	}	
	

}
