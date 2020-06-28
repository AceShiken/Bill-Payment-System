package com.setu.billpaymentsystem.Bill.Payment.System.repository;

import com.setu.billpaymentsystem.Bill.Payment.System.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Bill, Integer> {
}
