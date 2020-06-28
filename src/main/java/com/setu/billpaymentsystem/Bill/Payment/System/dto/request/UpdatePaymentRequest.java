package com.setu.billpaymentsystem.Bill.Payment.System.dto.request;

import com.setu.billpaymentsystem.Bill.Payment.System.pojo.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePaymentRequest {
    private String refID;
    private Transaction transaction;
}
