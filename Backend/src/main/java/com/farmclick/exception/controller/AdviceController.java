package com.farmclick.exception.controller;

import com.farmclick.exception.ExceptionResponse;
import com.farmclick.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@ControllerAdvice
public class AdviceController {

//    private final Logger logger = LogManager.getLogger();

    private void printError(Exception e){
        System.err.print(new Timestamp(new Date().getTime()) + "  EXCEPTION: " + e.getMessage());
        e.printStackTrace();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFound(final UserNotFoundException exception) {
        String errorMessage = exception.toString();
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
        this.printError(exception);
//        logger.error(Arrays.toString(exception.getStackTrace()));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
