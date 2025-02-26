package com.example.aprilproject.domain.company.port;

import com.example.aprilproject.domain.company.dto.CompanyInfosResponse;

import java.util.List;

public interface ShowInfoPort {
    List<CompanyInfosResponse> showInfo();
}
