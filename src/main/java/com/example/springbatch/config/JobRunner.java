package com.example.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

 
    public void runJob() {
        try {
            jobLauncher.run(job, new JobParameters());
            System.out.println("Scheduled job has started successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

