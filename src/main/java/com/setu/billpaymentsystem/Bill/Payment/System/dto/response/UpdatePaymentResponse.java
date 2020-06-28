package com.setu.billpaymentsystem.Bill.Payment.System.dto.response;

import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import com.setu.billpaymentsystem.Bill.Payment.System.pojo.PaymentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePaymentResponse {
    private ApiStatus status;
    private PaymentData data;
}
