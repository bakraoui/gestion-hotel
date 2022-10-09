package com.example.demo.exceptions;

public class ReservationFoundInSameDateException extends RuntimeException {
    public ReservationFoundInSameDateException(String message)  {
        super(message);
    }
}
