package com.bci.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bci.api.entity.PhoneEntity;
import com.bci.api.repository.IPhoneRepository;

public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneRepository iphoneRepository;
	
	@Override
	public String save(List<PhoneEntity> user) {
		
		
		return null;
	}

}
