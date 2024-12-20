package com.example.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbatch.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
