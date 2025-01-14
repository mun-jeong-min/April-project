package com.example.aprilproject.domain.user.mapper;

import com.example.aprilproject.domain.user.domain.UserEntity;
import com.example.aprilproject.domain.user.entity.User;

public interface UserMapper {
    UserEntity userDomainToEntity(User user);
    User userEntityToDomain(UserEntity userEntity);
}
