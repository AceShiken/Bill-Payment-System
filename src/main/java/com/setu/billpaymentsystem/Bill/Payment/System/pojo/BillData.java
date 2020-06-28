package com.setu.billpaymentsystem.Bill.Payment.System.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillData {
    private String customerName;
    private Integer dueAmount;
    private Date dueDate;
    private String refId;
}
