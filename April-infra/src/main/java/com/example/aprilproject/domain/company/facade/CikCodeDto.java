package com.example.aprilproject.domain.company.facade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CikCodeDto {
    private int cikStr;
    private String ticker;
    private String title;
}
