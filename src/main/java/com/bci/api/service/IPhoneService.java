package com.bci.api.service;

import java.util.List;
import java.util.UUID;

import com.bci.api.dto.PhoneResponseDto;

public interface IPhoneService {
	
	List<PhoneResponseDto> phones();
	
	List<PhoneResponseDto> phonesByUser(UUID uuid);	

}
