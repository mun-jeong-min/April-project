package com.example.aprilproject.domain.company.domain;

import com.example.aprilproject.domain.company.domain.repository.CompanyRepository;
import com.example.aprilproject.domain.company.dto.CompanyInfosResponse;
import com.example.aprilproject.domain.company.exception.CompanyNotFoundException;
import com.example.aprilproject.domain.company.facade.CikCodeDto;
import com.example.aprilproject.domain.company.facade.CompanyDto;
import com.example.aprilproject.domain.company.facade.CompanyFacade;
import com.example.aprilproject.domain.company.mapper.CompanyMapper;
import com.example.aprilproject.domain.company.repository.SaveInfoSpi;
import com.example.aprilproject.domain.company.repository.ShowInfoSpi;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class CompanyCustomAdapter implements SaveInfoSpi, ShowInfoSpi {

    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    private final CompanyFacade companyFacade;

    @Transactional
    public void saveInfo(String name) {
        CikCodeDto cikCodeDto = companyFacade.getCikCode(name);

        int cikCode = cikCodeDto.getCikStr();
        CompanyDto companyDto = companyFacade.getCompanyInfo(cikCode);

        String tenK = String.format("https://www.sec.gov/Archives/edgar/data/%d/%s/%s-%s.htm",
                cikCode,
                companyDto.getTenKNumber().replaceAll("-", ""),
                name.toLowerCase(),
                companyDto.getTenKDate().replaceAll("-", "")
        );
        String eightK = String.format("https://www.sec.gov/Archives/edgar/data/%d/%s/%s-%s.htm",
                cikCode,
                companyDto.getEightKNumber().replaceAll("-", ""),
                name.toLowerCase(),
                companyDto.getEightKDate().replaceAll("-", "")
        );
        String def14A = String.format("https://www.sec.gov/Archives/edgar/data/%d/%s/%s-%s.htm",
                cikCode,
                companyDto.getDef14ANumber().replaceAll("-", ""),
                name.toLowerCase(),
                companyDto.getDef14ADate().replaceAll("-", "")
        );

        // cikCode로 찾고 만약 이미 존재하는 경우 업데이트
        if(companyRepository.findByCikCode(cikCode).isPresent()) {
            CompanyEntity company = companyRepository.findByCikCode(cikCode).orElseThrow(() -> CompanyNotFoundException.EXCEPTION);
            companyRepository.delete(company);
        }

        companyRepository.save(
                CompanyEntity.builder()
                        .name(cikCodeDto.getTitle())
                        .info(cikCodeDto.getTicker())
                        .tenK(tenK)
                        .eightK(eightK)
                        .def14a(def14A)
                        .cikCode(cikCodeDto.getCikStr())
                        .build()
        );
    }

    @Transactional
    public List<CompanyInfosResponse> showInfo() {

        return companyRepository.findAll().stream()
                .map(company -> new CompanyInfosResponse(
                        company.getName(),
                        company.getInfo(),
                        company.getCikCode(),
                        company.getDef14a(),
                        company.getEightK(),
                        company.getTenK()
                ))
                .toList();
    }
}
