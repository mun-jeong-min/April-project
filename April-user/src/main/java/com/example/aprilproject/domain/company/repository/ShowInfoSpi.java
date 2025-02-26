package com.example.aprilproject.domain.company.repository;

import com.example.aprilproject.annotation.Spi;
import com.example.aprilproject.domain.company.dto.CompanyInfosResponse;

import java.util.List;

@Spi
public interface ShowInfoSpi {
    List<CompanyInfosResponse> showInfo();
}
