package com.example.aprilproject.domain.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "tbl_user")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    private String name;

    @Column(columnDefinition = "VARCHAR(500)")
    @NotNull
    private String password;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotNull
    private String email;
}
