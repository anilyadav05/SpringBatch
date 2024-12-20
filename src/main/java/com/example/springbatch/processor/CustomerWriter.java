package com.example.springbatch.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.Chunk;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.springbatch.entity.Customer;

@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(Chunk<? extends Customer> customers) throws Exception {
  
        String sql = "INSERT INTO customer (id,customer_id, first_name, last_name, company, city, country, phone1, phone2, email, subscription_date, website) " +
                     "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();


        for (Customer customer : customers) {
            batchArgs.add(new Object[] { 
            	customer.getIndex(),
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCompany(),
                customer.getCity(),
                customer.getCountry(),
                customer.getPhone1(),
                customer.getPhone2(),
                customer.getEmail(),
                customer.getSubscriptionDate(),
                customer.getWebsite()
            });
        }


        jdbcTemplate.batchUpdate(sql, batchArgs);

        System.out.println("Batch inserted " + customers.size() + " customers");
    }
}
