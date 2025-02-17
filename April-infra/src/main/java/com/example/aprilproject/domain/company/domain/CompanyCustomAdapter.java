package com.example.aprilproject.domain.company.domain;

import com.example.aprilproject.domain.company.domain.repository.CompanyRepository;
import com.example.aprilproject.domain.company.facade.CikCodeDto;
import com.example.aprilproject.domain.company.facade.CompanyDto;
import com.example.aprilproject.domain.company.facade.CompanyFacade;
import com.example.aprilproject.domain.company.mapper.CompanyMapper;
import com.example.aprilproject.domain.company.port.SaveInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CompanyCustomAdapter implements SaveInfoPort {

    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;
    private final CompanyFacade companyFacade;

    @Override
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

        companyRepository.save(
                CompanyEntity.builder()
                        .name(cikCodeDto.getTitle())
                        .info(cikCodeDto.getTicker())
                        .ten_k(tenK)
                        .eight_k(eightK)
                        .def_14a(def14A)
                        .cik_code(cikCodeDto.getCikStr())
                        .build()
        );
    }
}
