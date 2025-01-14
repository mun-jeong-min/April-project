package com.example.aprilproject.global.config;

import com.example.aprilproject.annotation.Spi;
import com.example.aprilproject.annotation.UseCase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.example.aprilproject",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                UseCase.class,
                                Spi.class
                        }
                )
        }
)
public class ComponentScanConfig {
}
