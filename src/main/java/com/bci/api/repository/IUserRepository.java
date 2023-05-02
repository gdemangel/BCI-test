package com.bci.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bci.api.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

}
