package com.example.aprilproject.domain.company.adapter;

import com.example.aprilproject.annotation.UseCase;
import com.example.aprilproject.domain.company.dto.CompanyInfosResponse;
import com.example.aprilproject.domain.company.port.ShowInfoPort;
import com.example.aprilproject.domain.company.repository.ShowInfoSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class showInfoAdapter implements ShowInfoPort {
    private final ShowInfoSpi showInfoSpi;

    @Override
    public List<CompanyInfosResponse> showInfo() {
        return showInfoSpi.showInfo();
    }
}
