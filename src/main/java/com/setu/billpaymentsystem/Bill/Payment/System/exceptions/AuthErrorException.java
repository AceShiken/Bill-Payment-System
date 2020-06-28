package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthErrorException extends Exception{
    public AuthErrorException(String message) {
        super(message);
    }
}
