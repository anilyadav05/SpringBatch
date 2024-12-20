package com.example.springbatch.processor;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.springbatch.entity.Customer;

@Configuration
public class CsvReaderConfig {

    @Bean
    public FlatFileItemReader<Customer> csvReader() {
        return new FlatFileItemReaderBuilder<Customer>()
                .name("csv-reader")
                .resource(new ClassPathResource("customers.csv"))  
                .delimited()
                .names("Index", "Customer Id", "First Name", "Last Name", "Company", 
                        "City", "Country", "Phone 1", "Phone 2", "Email", 
                        "Subscription Date", "Website")
                .linesToSkip(1)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
                    setTargetType(Customer.class); 
                }})
                .build();
    }
}
