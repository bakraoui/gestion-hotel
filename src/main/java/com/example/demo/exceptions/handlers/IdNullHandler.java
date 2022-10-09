package com.example.demo.exceptions.handlers;

import com.example.demo.exceptions.ApiError;
import com.example.demo.exceptions.IdNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class IdNullHandler {


    @ExceptionHandler(IdNullException.class)
    public ResponseEntity<Object> handleIdNull(IdNullException e) {
        ApiError error = new ApiError(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                new Date()
        );

        return new ResponseEntity<>(error,error.getStatus());
    }
}
