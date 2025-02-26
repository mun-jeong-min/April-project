package com.example.aprilproject.domain.company.presentation;

import com.example.aprilproject.domain.company.dto.CompanyInfosResponse;
import com.example.aprilproject.domain.company.port.SaveInfoPort;
import com.example.aprilproject.domain.company.port.ShowInfoPort;
import com.example.aprilproject.domain.company.presentation.dto.CompanyInfoSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final SaveInfoPort saveInfoPort;
    private final ShowInfoPort showInfoPort;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public void saveInfo(@RequestBody CompanyInfoSaveRequest request) {
        saveInfoPort.saveInfo(request.getName());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/show")
    public List<CompanyInfosResponse> showInfo() {
        return showInfoPort.showInfo();
    }
}
