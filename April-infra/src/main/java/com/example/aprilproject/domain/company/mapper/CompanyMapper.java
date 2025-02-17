package com.example.aprilproject.domain.company.mapper;

import com.example.aprilproject.domain.company.domain.CompanyEntity;
import com.example.aprilproject.domain.company.entity.Company;

public interface CompanyMapper {
    CompanyEntity companyDomainToEntity(Company company);
    Company companyEntityToDomain(CompanyEntity companyEntity);
}
