package com.example.aprilproject.domain.company.presentation;

import com.example.aprilproject.domain.company.presentation.dto.CompanyInfoSaveRequest;
import com.example.aprilproject.domain.company.repository.SaveInfoSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final SaveInfoSpi saveInfoSpi;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/company")
    public void saveInfo(@RequestBody CompanyInfoSaveRequest request) {
        saveInfoSpi.saveInfo(request.getName());
    }
}
