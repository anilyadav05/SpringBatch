package com.example.springbatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.springbatch.entity.Customer;

@Component
public class NameProcessor implements 
        ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) {
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());
        
        return customer;
    }
}
