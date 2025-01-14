package com.example.aprilproject.domain.user.mapper;

import com.example.aprilproject.domain.user.domain.UserEntity;
import com.example.aprilproject.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity userDomainToEntity(User user) {
        return UserEntity.builder()
                .name(user.getName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User userEntityToDomain(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .build();
    }
}
