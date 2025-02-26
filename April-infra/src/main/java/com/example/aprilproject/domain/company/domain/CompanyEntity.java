package com.example.aprilproject.domain.company.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_company")
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull
    private String name;

    @Column(columnDefinition = "VARCHAR(200)")
    @NotNull
    private String info;

    @Column(columnDefinition = "VARCHAR(5000)")
    @NotNull
    private String tenK;

    @Column(columnDefinition = "VARCHAR(5000)")
    @NotNull
    private String def14a;

    @Column(columnDefinition = "VARCHAR(5000)")
    @NotNull
    private String eightK;

    @Column(columnDefinition = "int(30)")
    @NotNull
    private int cikCode;

}
