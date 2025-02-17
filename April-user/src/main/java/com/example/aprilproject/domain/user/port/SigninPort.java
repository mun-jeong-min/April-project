package com.example.aprilproject.domain.user.port;

import com.example.aprilproject.domain.user.dto.LoginResponse;

public interface SigninPort {
    LoginResponse signin(String email, String pw);
}
