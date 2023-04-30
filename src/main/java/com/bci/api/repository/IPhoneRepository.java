package com.bci.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bci.api.entity.PhoneEntity;

public interface IPhoneRepository extends JpaRepository<PhoneEntity, Long>{

}
