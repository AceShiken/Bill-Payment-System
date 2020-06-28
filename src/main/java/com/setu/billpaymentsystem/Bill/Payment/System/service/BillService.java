package com.setu.billpaymentsystem.Bill.Payment.System.service;

import com.setu.billpaymentsystem.Bill.Payment.System.dto.request.BillRequest;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.request.UpdatePaymentRequest;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.response.FetchBillResponse;
import com.setu.billpaymentsystem.Bill.Payment.System.dto.response.UpdatePaymentResponse;
import com.setu.billpaymentsystem.Bill.Payment.System.enums.ApiStatus;
import com.setu.billpaymentsystem.Bill.Payment.System.exceptions.AmountMismatchException;
import com.setu.billpaymentsystem.Bill.Payment.System.exceptions.CustomerNotFoundException;
import com.setu.billpaymentsystem.Bill.Payment.System.exceptions.InvalidRefIdException;
import com.setu.billpaymentsystem.Bill.Payment.System.exceptions.UnhandledErrorException;
import com.setu.billpaymentsystem.Bill.Payment.System.model.Bill;
import com.setu.billpaymentsystem.Bill.Payment.System.model.Customer;
import com.setu.billpaymentsystem.Bill.Payment.System.pojo.BillData;
import com.setu.billpaymentsystem.Bill.Payment.System.pojo.PaymentData;
import com.setu.billpaymentsystem.Bill.Payment.System.pojo.Transaction;
import com.setu.billpaymentsystem.Bill.Payment.System.repository.BillRepository;
import com.setu.billpaymentsystem.Bill.Payment.System.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private CustomerRepository customer;

    @Autowired
    private BillRepository bill;

    public FetchBillResponse fetchBill(BillRequest billRequest) throws CustomerNotFoundException, UnhandledErrorException {
        try {
            String mobileNumber = billRequest.getMobileNumber();
            if (bill.findAll().stream().filter(bill -> bill.getMobileNumber().equals(mobileNumber)).collect(Collectors.toList()).isEmpty()) {
                throw new CustomerNotFoundException("customer-not-found");
            }

            Bill billByContact = bill.findAll().stream().filter(bill -> bill.getMobileNumber().equals(mobileNumber)).collect(Collectors.toList()).get(0);
            if (customer.findAll().stream().filter(customer -> customer.getMobileNumber().equals(mobileNumber)).collect(Collectors.toList()).isEmpty()) {
                throw new CustomerNotFoundException("customer-not-found");
            }
            Customer customerAgainstBill = customer.findAll().stream().filter(customer -> customer.getMobileNumber().equals(mobileNumber)).collect(Collectors.toList()).get(0);

            BillData billData = new BillData(customerAgainstBill.getName(), billByContact.getDueAmount(), billByContact.getDueDate(), billByContact.getRefID());
            return new FetchBillResponse(ApiStatus.SUCCESS, billData);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException("customer-not-found");
        } catch (Exception e) {
            throw new UnhandledErrorException("unhandled-error");
        }
    }

    public UpdatePaymentResponse updatePayment(UpdatePaymentRequest request) throws AmountMismatchException, InvalidRefIdException, UnhandledErrorException {
        try {
            String refID = request.getRefID();
            Transaction transaction = request.getTransaction();
            List<Bill> allBills = bill.findAll();
            if (allBills.stream().filter(bill -> bill.getRefID().equals(refID)).collect(Collectors.toList()).isEmpty()) {
                throw new InvalidRefIdException("invalid-ref-id");
            }
            Bill billByRefID = bill.findAll().stream().filter(bill -> bill.getRefID().equals(refID)).collect(Collectors.toList()).get(0);
            Integer amountPaid = transaction.getAmountPaid();
            billByRefID.getTransactions().add(transaction);
            if (!billByRefID.getDueAmount().equals(amountPaid)) {
                throw new AmountMismatchException("amount-mismatch");
            }
            billByRefID.setDueAmount(0);
            billByRefID.setDueDate(null);
            billByRefID.setRefID(transaction.getId());
            bill.save(billByRefID);
            return new UpdatePaymentResponse(ApiStatus.SUCCESS, new PaymentData(transaction.getId()));
        } catch (InvalidRefIdException e) {
            throw new InvalidRefIdException("invalid-ref-id");
        } catch (AmountMismatchException e) {
            throw new AmountMismatchException("amount-mismatch");
        } catch (Exception e) {
            throw new UnhandledErrorException("unhandled-error");
        }
    }

    public List<Customer> getAllCustomers() {
        return customer.findAll();
    }
}
