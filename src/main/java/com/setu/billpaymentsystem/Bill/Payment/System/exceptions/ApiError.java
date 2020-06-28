package com.setu.billpaymentsystem.Bill.Payment.System.exceptions;

import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class ApiError {
    private ApiStatus status = ApiStatus.ERROR;
    private String error;
    public ApiError(Exception e) {
        this.error = e.getMessage();
    }
}
