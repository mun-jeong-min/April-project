package com.example.aprilproject.domain.user.domain.repository;

import com.example.aprilproject.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
