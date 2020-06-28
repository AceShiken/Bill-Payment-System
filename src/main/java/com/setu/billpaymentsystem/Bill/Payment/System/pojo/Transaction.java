package com.setu.billpaymentsystem.Bill.Payment.System.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    private Integer amountPaid;
    private Date date;
    private String id;
}
