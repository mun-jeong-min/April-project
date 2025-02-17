package com.example.aprilproject.domain.user.repository;

import com.example.aprilproject.annotation.Spi;

@Spi
public interface SigninSpi {
    String signin(String email, String pw);
}
