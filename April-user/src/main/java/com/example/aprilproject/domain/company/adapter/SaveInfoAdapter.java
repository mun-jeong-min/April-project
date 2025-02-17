package com.example.aprilproject.domain.company.adapter;

import com.example.aprilproject.annotation.UseCase;
import com.example.aprilproject.domain.company.port.SaveInfoPort;
import com.example.aprilproject.domain.company.repository.SaveInfoSpi;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveInfoAdapter implements SaveInfoPort {

    private final SaveInfoSpi saveInfoSpi;

    @Override
    public void saveInfo(String name) {
        saveInfoSpi.saveInfo(name);
    }
}
