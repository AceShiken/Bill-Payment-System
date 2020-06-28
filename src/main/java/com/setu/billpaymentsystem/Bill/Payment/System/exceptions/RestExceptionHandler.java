package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "invalid-api-parameters";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "path-not-found";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "path-not-found";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "invalid-api-parameters";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "invalid-api-parameters";
        return buildResponseEntity(new ApiError(ApiStatus.ERROR, error));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
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

    @ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            CustomerNotFoundException ex) {
        ApiError apiError = new ApiError(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidAPIParametersException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            InvalidAPIParametersException ex) {
        ApiError apiError = new ApiError(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidRefIdException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            InvalidRefIdException ex) {
        ApiError apiError = new ApiError(ex);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(UnhandledErrorException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            UnhandledErrorException ex) {
        ApiError apiError = new ApiError(ex);
        return buildResponseEntity(apiError);
    }

}
