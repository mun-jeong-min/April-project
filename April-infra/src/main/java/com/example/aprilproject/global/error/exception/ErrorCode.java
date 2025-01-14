package com.example.aprilproject.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    EXPIRED_JWT(401, "jwt-401-1", "토큰 만료"),
    INVALID_JWT(401, "jwt-401-1", "토큰 인증 실패"),
    USER_EXIST(401, "CLIENT-401-1", "이미 유저 존재"),

    USER_NOT_FOUND(404, "CLIENT-404-1", "User Not Found"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error");

    private final int status;
    private final String code;
    private final String message;
}
