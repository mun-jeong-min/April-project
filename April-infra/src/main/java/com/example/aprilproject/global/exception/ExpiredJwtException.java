package com.example.aprilproject.global.exception;

import com.example.aprilproject.global.error.exception.ErrorCode;
import com.example.aprilproject.global.error.exception.GlobalException;

public class ExpiredJwtException extends GlobalException {
    public static final ExpiredJwtException EXCEPTION =
            new ExpiredJwtException();

    public ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
