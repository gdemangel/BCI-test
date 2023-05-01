package com.bci.api.dto;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bci.api.entity.UserEntity;

@Mapper(
		componentModel = "spring",
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
		)
public abstract class UserMapper {
	
	public abstract UserEntity toModel(UserRequestDto user);
	
	public abstract UserResponseDto toDto(UserEntity user);
	
	public abstract UserResponseAllDto toAllDto(UserEntity us);
	
}
