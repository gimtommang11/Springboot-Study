package com.example.test1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong Info")
public class WrongInfo extends RuntimeException {
    public WrongInfo(String message) {
        super(message);
    }
}
