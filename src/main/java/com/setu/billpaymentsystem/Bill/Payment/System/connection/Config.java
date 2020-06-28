package com.setu.billpaymentsystem.Bill.Payment.System.connection;

import com.setu.billpaymentsystem.Bill.Payment.System.generator.IDGenerator;
import com.setu.billpaymentsystem.Bill.Payment.System.model.Bill;
import com.setu.billpaymentsystem.Bill.Payment.System.model.Customer;
import com.setu.billpaymentsystem.Bill.Payment.System.repository.CustomerRepository;
import com.setu.billpaymentsystem.Bill.Payment.System.repository.BillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Date;

@EnableMongoRepositories(basePackageClasses = {CustomerRepository.class, BillRepository.class})
@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                        BillRepository billRepository) {
        return args -> {
            customerRepository.deleteAll();
            customerRepository.save(new Customer(IDGenerator.generateId(), "Jake", "9843275201"));
            customerRepository.save(new Customer(IDGenerator.generateId(), "Judy", "9843235201"));
            customerRepository.save(new Customer(IDGenerator.generateId(), "John", "9843745201"));
            customerRepository.save(new Customer(IDGenerator.generateId(), "Jim", "9843253401"));
            customerRepository.save(new Customer(IDGenerator.generateId(), "Julia", "9843765201"));

            billRepository.deleteAll();
            billRepository.save(new Bill(IDGenerator.generateId(), "9843275201", new ArrayList<>(), 10000, new Date(), IDGenerator.generateRandomAlphaNumericId(9)));
            billRepository.save(new Bill(IDGenerator.generateId(), "9843235201", new ArrayList<>(), 6000, new Date(), IDGenerator.generateRandomAlphaNumericId(9)));
            billRepository.save(new Bill(IDGenerator.generateId(), "9843745201", new ArrayList<>(), 3000, new Date(), IDGenerator.generateRandomAlphaNumericId(9)));
            billRepository.save(new Bill(IDGenerator.generateId(), "9843253401", new ArrayList<>(), 2000, new Date(), IDGenerator.generateRandomAlphaNumericId(9)));
            billRepository.save(new Bill(IDGenerator.generateId(), "9843765201", new ArrayList<>(), 900, new Date(), IDGenerator.generateRandomAlphaNumericId(9)));
        };
    }
}
