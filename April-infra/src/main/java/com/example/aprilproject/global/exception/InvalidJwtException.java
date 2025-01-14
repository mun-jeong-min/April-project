package com.example.aprilproject.global.exception;

import com.example.aprilproject.global.error.exception.ErrorCode;
import com.example.aprilproject.global.error.exception.GlobalException;

public class InvalidJwtException extends GlobalException {
    public static final InvalidJwtException EXCEPTION =
            new InvalidJwtException();

    public InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
