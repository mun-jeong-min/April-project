package com.example.aprilproject.domain.user.exception;

import com.example.aprilproject.global.error.exception.ErrorCode;
import com.example.aprilproject.global.error.exception.GlobalException;

public class UserExistException extends GlobalException {
    public static final UserExistException EXCEPTION =
            new UserExistException();

    public UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
