package com.example.aprilproject.domain.user.port;

import com.example.aprilproject.domain.user.dto.UserResponse;

public interface LoginPort {
    void saveUser(String name, String pw, String email);
}
