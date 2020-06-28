package com.setu.billpaymentsystem.Bill.Payment.System.repository;

import com.setu.billpaymentsystem.Bill.Payment.System.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
