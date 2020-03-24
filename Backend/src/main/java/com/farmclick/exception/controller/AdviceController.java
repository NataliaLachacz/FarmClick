package com.farmclick.exception.controller;

import com.farmclick.exception.ExceptionResponse;
import com.farmclick.exception.PlantNotFoundException;
import com.farmclick.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    private final static Logger logger = LoggerFactory.getLogger(AdviceController.class);

    private void logError(Exception e) {
        logger.error(e.getMessage(), e);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFound(final UserNotFoundException exception) {
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlantNotFoundException.class)
    public ResponseEntity<ExceptionResponse> plantNotFound(final PlantNotFoundException exception) {
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ExceptionResponse> securityException(final SecurityException exception) {
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.FORBIDDEN.value(), errorMessage);
        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
