package com.example.aprilproject.domain.company.mapper;

import com.example.aprilproject.domain.company.domain.CompanyEntity;
import com.example.aprilproject.domain.company.entity.Company;

public class CompanyMapperImpl implements CompanyMapper{
    @Override
    public CompanyEntity companyDomainToEntity(Company company) {
        return CompanyEntity.builder()
                .name(company.getName())
                .info(company.getInfo())
                .ten_k(company.getTenK())
                .def_14a(company.getDef_14a())
                .eight_k(company.getEightK())
                .cik_code(company.getCikCode())
                .build();
    }

    @Override
    public Company companyEntityToDomain(CompanyEntity companyEntity) {
        return Company.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .info(companyEntity.getInfo())
                .tenK(companyEntity.getTen_k())
                .def_14a(companyEntity.getDef_14a())
                .eightK(companyEntity.getEight_k())
                .cikCode(companyEntity.getCik_code())
                .build();
    }
}
