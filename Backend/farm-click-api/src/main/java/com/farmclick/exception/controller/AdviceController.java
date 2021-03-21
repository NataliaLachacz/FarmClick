package com.farmclick.exception.controller;

import com.farmclick.exception.ExceptionResponse;
import com.farmclick.exception.PlantNotFoundException;
import com.farmclick.exception.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log4j2
@ControllerAdvice
public class AdviceController {

    private void logError(Exception e) {
        log.error(e.getMessage(), e);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFound(final UserNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, status);
    }

    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<ExceptionResponse> plantNotFound(final PlantNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, status);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ExceptionResponse> securityException(final SecurityException exception) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, status);
    }

}
