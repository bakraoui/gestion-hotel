package com.example.demo.exceptions;

public class ObjectAlreadyExistException extends RuntimeException {
    public ObjectAlreadyExistException(String s) {
        super(s);
    }
}
