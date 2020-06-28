package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountMismatchException extends Exception{
    public AmountMismatchException(String message) {
        super(message);
    }
}
