package com.setu.billpaymentsystem.Bill.Payment.System.dto.response;

import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import com.setu.billpaymentsystem.Bill.Payment.System.pojo.BillData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FetchBillResponse {
    private ApiStatus status;
    private BillData data;
}
