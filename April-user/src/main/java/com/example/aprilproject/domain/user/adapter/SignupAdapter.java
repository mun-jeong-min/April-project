package com.example.aprilproject.domain.user.adapter;

import com.example.aprilproject.domain.user.entity.User;
import com.example.aprilproject.domain.user.port.SignupPort;
import com.example.aprilproject.annotation.UseCase;
import com.example.aprilproject.domain.user.repository.SaveUserSpi;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SignupAdapter implements SignupPort {

    private final SaveUserSpi saveUserSpi;

    public void saveUser(String name, String pw, String email) {

        User user = User.builder()
                .name(name)
                .password(pw)
                .email(email)
                .build();


        saveUserSpi.saveUser(user);
    }
}
