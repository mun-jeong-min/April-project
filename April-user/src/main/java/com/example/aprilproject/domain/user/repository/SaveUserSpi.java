package com.example.aprilproject.domain.user.repository;

import com.example.aprilproject.annotation.Spi;
import com.example.aprilproject.domain.user.entity.User;

@Spi
public interface SaveUserSpi {
    void saveUser(User user);
}
