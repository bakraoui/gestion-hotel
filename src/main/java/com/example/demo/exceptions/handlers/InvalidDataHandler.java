package com.example.demo.exceptions.handlers;


import com.example.demo.exceptions.ApiError;
import com.example.demo.exceptions.InvalideData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvalidDataHandler {

    @ExceptionHandler(InvalideData.class)
    public ResponseEntity<Object> handleInvalidData(InvalideData exc) {
        ApiError error = new ApiError(
                exc.getMessage(),
                HttpStatus.BAD_REQUEST,
                new Date()
        );

        return new ResponseEntity<> (error, error.getStatus());
    }
}
