package com.example.aprilproject.domain.company.entity;

import com.example.aprilproject.annotation.Aggregate;
import lombok.*;

@Aggregate
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Company {
    private Long id;
    private String name;
    private String info;
    private String tenK;
    private String def_14a;
    private String eightK;
    private int cikCode;
}
