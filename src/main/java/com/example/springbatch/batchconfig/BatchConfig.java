package com.example.springbatch.batchconfig;

import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.springbatch.entity.Customer;
import com.example.springbatch.listener.JobExecutionTimeListener;
import com.example.springbatch.processor.CustomerWriter;
import com.example.springbatch.processor.NameProcessor;
import com.example.springbatch.repository.CustomerRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	
    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private NameProcessor processor;

    @Autowired
    private CustomerWriter writer;
    
    @Autowired
    private FlatFileItemReader<Customer> csvReader;
    
    @Autowired
    private JobExecutionTimeListener jobExecutionTimeListener;
	
    @Bean
    public Job job() {
        
        return new JobBuilder("customer-loader-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(readerStep())
                .build();
    }
    
    
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(20); 
        return taskExecutor;
    }
    
    @Bean
    public Step readerStep() {

        return new StepBuilder("name-step", jobRepository)
                .<Customer, Customer>chunk(500, transactionManager)
                .reader(csvReader)
                .processor(processor)
                .writer(writer)
                .listener(jobExecutionTimeListener)
                .allowStartIfComplete(true)
                .taskExecutor(taskExecutor())
                .build();
    }
    

    @Bean
    public RepositoryItemReader<Customer> repositoryReader(
            CustomerRepository customerRepository) {
        
        return new RepositoryItemReaderBuilder<Customer>()
                .repository(customerRepository)
                .methodName("findAll")
                .sorts(Map.of("id", Sort.Direction.ASC))
                .name("repository-reader")
                .build();
    }

    

}
