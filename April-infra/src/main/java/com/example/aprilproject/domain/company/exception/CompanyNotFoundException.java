package com.example.aprilproject.domain.company.exception;

import com.example.aprilproject.global.error.exception.ErrorCode;
import com.example.aprilproject.global.error.exception.GlobalException;

public class CompanyNotFoundException extends GlobalException {
    public static final CompanyNotFoundException EXCEPTION =
            new CompanyNotFoundException();

    public CompanyNotFoundException() {
        super(ErrorCode.COMPANY_NOT_FOUND);
    }
}
