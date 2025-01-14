package com.example.aprilproject.domain.user.domain;

import com.example.aprilproject.domain.user.domain.repository.UserRepository;
import com.example.aprilproject.domain.user.entity.User;
import com.example.aprilproject.domain.user.exception.UserExistException;
import com.example.aprilproject.domain.user.mapper.UserMapper;
import com.example.aprilproject.domain.user.repository.SaveUserSpi;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCustomAdapter implements SaveUserSpi {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional
    public void saveUser(User user) {
        User users = User.builder()
                .name(user.getName())
                .password(passwordEncoder.encode(user.getPassword()))
                .email(user.getEmail())
                .build();

        UserEntity userEntity = userMapper.userDomainToEntity(users);

        if(userRepository.findByEmail(userEntity.getEmail()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(userEntity);
    }
}
