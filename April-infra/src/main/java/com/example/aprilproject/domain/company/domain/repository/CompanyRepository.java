package com.example.aprilproject.domain.company.domain.repository;

import com.example.aprilproject.domain.company.domain.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
}
