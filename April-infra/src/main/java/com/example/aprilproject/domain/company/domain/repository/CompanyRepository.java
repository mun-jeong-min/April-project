package com.example.aprilproject.domain.company.domain.repository;

import com.example.aprilproject.domain.company.domain.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByCikCode(int cikCode);
}
