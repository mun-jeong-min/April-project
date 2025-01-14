package com.example.aprilproject.domain.user.entity;

import com.example.aprilproject.annotation.Aggregate;
import lombok.*;

@Aggregate
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
}
