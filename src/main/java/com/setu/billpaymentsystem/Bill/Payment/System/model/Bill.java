package com.setu.billpaymentsystem.Bill.Payment.System.model;

import com.setu.billpaymentsystem.Bill.Payment.System.pojo.Transaction;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Bill {

    @Id
    private Long id;
    private String mobileNumber;
    private List<Transaction> transactions;
    private Integer dueAmount;
    private Date dueDate;
    private String refID;

    public Bill(Long id, String mobileNumber, List<Transaction> transactions, Integer dueAmount, Date dueDate, String refID) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.transactions = transactions;
        this.dueAmount = dueAmount;
        this.dueDate = dueDate;
        this.refID = refID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Integer getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }


}
