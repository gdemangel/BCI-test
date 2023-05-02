package com.bci.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bci.api.entity.PhoneEntity;

public interface IPhoneRepository extends JpaRepository<PhoneEntity, UUID>{

	List<PhoneEntity> findByUserId(UUID userId);
}
