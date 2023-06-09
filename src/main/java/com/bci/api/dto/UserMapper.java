package com.bci.api.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
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
	
	public abstract UserEntity toModel(UserRequestDto us);
	
	public abstract UserResponseDto toDto(UserEntity us);
	
	public abstract UserResponseAllDto toAllDto(UserEntity us);	
	
	public abstract void updateModel(UserRequestDto userRequestDto, @MappingTarget UserEntity userEntity);
	
}
