package com.example.aprilproject.domain.user.adapter;

import com.example.aprilproject.annotation.UseCase;
import com.example.aprilproject.domain.user.dto.LoginResponse;
import com.example.aprilproject.domain.user.port.SigninPort;
import com.example.aprilproject.domain.user.repository.SigninSpi;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SigninAdapter implements SigninPort {

    private final SigninSpi signinSpi;

    @Override
    public LoginResponse signin(String email, String pw) {
        return new LoginResponse(signinSpi.signin(email, pw));
    }
}
