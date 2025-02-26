package com.example.aprilproject.domain.company.presentation;

import com.example.aprilproject.domain.company.port.SaveInfoPort;
import com.example.aprilproject.domain.company.presentation.dto.CompanyInfoSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final SaveInfoPort saveInfoPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void saveInfo(@RequestBody CompanyInfoSaveRequest request) {
        saveInfoPort.saveInfo(request.getName());
    }
}
