package com.example.aprilproject.domain.user.port;

public interface SignupPort {
    void saveUser(String name, String pw, String email);
}
