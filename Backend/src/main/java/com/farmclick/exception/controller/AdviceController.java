package com.farmclick.exception.controller;

import com.farmclick.exception.ExceptionResponse;
import com.farmclick.exception.LoginException;
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

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ExceptionResponse> loginException(final LoginException exception) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        String errorMessage = "Invalid credentials.";//exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), errorMessage);
//        this.logError(exception);
        return new ResponseEntity<>(exceptionResponse, status);
    }

}
