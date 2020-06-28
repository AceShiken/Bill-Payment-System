package com.setu.billpaymentsystem.Bill.Payment.System.controller;

import com.setu.billpaymentsystem.Bill.Payment.System.dto.request.BillRequest;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.request.UpdatePaymentRequest;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.response.FetchBillResponse;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.response.UpdatePaymentResponse;
import com.setu.billpaymentsystem.Bill.Payment.System.exceptions.*;
import com.setu.billpaymentsystem.Bill.Payment.System.model.Customer;
import com.setu.billpaymentsystem.Bill.Payment.System.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping(value = "/fetch-bill", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FetchBillResponse fetchBill(@RequestBody BillRequest billRequest) throws AuthErrorException, CustomerNotFoundException, UnhandledErrorException {
        return billService.fetchBill(billRequest);
    }

    @PostMapping(value = "/payment-update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UpdatePaymentResponse updatePayment(@RequestBody UpdatePaymentRequest request) throws AmountMismatchException, InvalidRefIdException, UnhandledErrorException, AuthErrorException {
        return billService.updatePayment(request);
    }

    @GetMapping(value= "/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return billService.getAllCustomers();
    }
}
