package com.example.aprilproject.global.error;

import com.example.aprilproject.global.error.exception.ErrorCode;
import com.example.aprilproject.global.error.exception.GlobalException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobal(GlobalException e) {
        final ErrorCode errorCode = e.getErrorCode();
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(400)
                        .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleValidException(BindException e) {

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(400)
                        .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidException(ConstraintViolationException e) {

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(400)
                        .message(e.getMessage())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }
}
