package com.example.aprilproject.domain.company.mapper;

import com.example.aprilproject.domain.company.domain.CompanyEntity;
import com.example.aprilproject.domain.company.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapperImpl implements CompanyMapper{
    @Override
    public CompanyEntity companyDomainToEntity(Company company) {
        return CompanyEntity.builder()
                .name(company.getName())
                .info(company.getInfo())
                .tenK(company.getTenK())
                .def14a(company.getDef_14a())
                .eightK(company.getEightK())
                .cikCode(company.getCikCode())
                .build();
    }

    @Override
    public Company companyEntityToDomain(CompanyEntity companyEntity) {
        return Company.builder()
                .id(companyEntity.getId())
                .name(companyEntity.getName())
                .info(companyEntity.getInfo())
                .tenK(companyEntity.getTenK())
                .def_14a(companyEntity.getDef14a())
                .eightK(companyEntity.getEightK())
                .cikCode(companyEntity.getCikCode())
                .build();
    }
}
