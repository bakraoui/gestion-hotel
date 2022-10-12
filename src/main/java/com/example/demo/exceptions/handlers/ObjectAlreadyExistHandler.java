package com.example.demo.exceptions.handlers;

import com.example.demo.exceptions.ApiError;
import com.example.demo.exceptions.ObjectAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ObjectAlreadyExistHandler {

    @ExceptionHandler(ObjectAlreadyExistException.class)
    public ResponseEntity<Object> handleObjectAlreadyExist(ObjectAlreadyExistException user){

        ApiError error = new ApiError(
                user.getMessage(),
                HttpStatus.BAD_REQUEST,
                new Date()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
