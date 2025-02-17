package com.example.aprilproject.domain.company.repository;

import com.example.aprilproject.annotation.Spi;

@Spi
public interface SaveInfoSpi {
    void saveInfo(String name);
}
