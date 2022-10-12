package com.example.demo.exceptions.handlers;

import com.example.demo.exceptions.ApiError;
import com.example.demo.exceptions.ReservationFoundInSameDateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ReservationFoundInTheSameDateHandler {


    @ExceptionHandler(ReservationFoundInSameDateException.class)
    public ResponseEntity<Object> handelReservationFoundInTheSameDate(ReservationFoundInSameDateException ex){
        ApiError apiError = new ApiError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                new Date()
        );
        return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);

    }
}
