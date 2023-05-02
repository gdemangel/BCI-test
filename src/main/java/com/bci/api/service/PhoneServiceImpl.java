package com.bci.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bci.api.dto.PhoneMapper;
import com.bci.api.dto.PhoneResponseDto;
import com.bci.api.entity.PhoneEntity;
import com.bci.api.repository.IPhoneRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneRepository phoneRepository;
	
	@Autowired
	private PhoneMapper mapper;

	@Override
	public List<PhoneResponseDto> phones() {

		List<PhoneEntity> phones = phoneRepository.findAll();
		
		List<PhoneResponseDto> phonesDto = new ArrayList<>();
		for(PhoneEntity p: phones) {
			
			phonesDto.add(mapper.toDto(p));			
		}
		return phonesDto;
	}

	@Override
	public List<PhoneResponseDto> phonesByUser(UUID uuid) {
		
		List<PhoneEntity> phones = phoneRepository.findByUserId(uuid);
		
		List<PhoneResponseDto> phonesDto = new ArrayList<>();
		for(PhoneEntity p: phones) {
			
			phonesDto.add(mapper.toDto(p));			
		}
		return phonesDto;
	}	

}
