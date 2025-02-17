package com.example.aprilproject.domain.user.domain;

import com.example.aprilproject.domain.user.domain.repository.UserRepository;
import com.example.aprilproject.domain.user.entity.User;
import com.example.aprilproject.domain.user.exception.UserExistException;
import com.example.aprilproject.domain.user.exception.UserNotFoundException;
import com.example.aprilproject.domain.user.mapper.UserMapper;
import com.example.aprilproject.domain.user.repository.SaveUserSpi;
import com.example.aprilproject.domain.user.repository.SigninSpi;
import com.example.aprilproject.global.security.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCustomAdapter implements SaveUserSpi, SigninSpi {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

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

    @Transactional
    public String signin(String email, String pw) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(pw, user.getPassword())) {
            throw UserNotFoundException.EXCEPTION;
        }
        return jwtTokenProvider.generateAccessToken(email);
    }
}
