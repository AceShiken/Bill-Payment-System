package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "invalid-api-parameters";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    //other exception handlers below

    @ExceptionHandler(AmountMismatchException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            AmountMismatchException ex) {
        ApiError apiError = new ApiError(ex);
        return buildResponseEntity(apiError);
    }

}
