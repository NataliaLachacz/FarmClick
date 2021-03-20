package com.farmclick.exception.controller;

import com.farmclick.exception.ExceptionResponse;
import com.farmclick.exception.LoginException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ExceptionResponse> securityException(final SecurityException exception) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
        return new ResponseEntity<>(exceptionResponse, status);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ExceptionResponse> loginException(final LoginException exception) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        String errorMessage = "Invalid credentials.";
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
        return new ResponseEntity<>(exceptionResponse, status);
    }

}
