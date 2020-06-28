package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UnhandledErrorException extends Exception{
    public UnhandledErrorException(String message) {
        super(message);
    }
}
