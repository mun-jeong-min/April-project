package com.example.aprilproject.domain.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyInfosResponse {
    private String name;
    private String info;
    private int cikCode;
    private String def14a;
    private String eightK;
    private String tenK;
}
