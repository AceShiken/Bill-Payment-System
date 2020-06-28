package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRefIdException extends Exception{
    public InvalidRefIdException(String message) {
        super(message);
    }
}
