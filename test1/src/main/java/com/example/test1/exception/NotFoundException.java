package com.example.test1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Account Not Found")
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
