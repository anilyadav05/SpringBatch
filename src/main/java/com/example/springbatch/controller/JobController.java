package com.example.springbatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbatch.config.JobRunner;

@RestController
public class JobController {

    @Autowired
    private JobRunner jobRunner;

    @GetMapping("/run-job")
    public String runJob() {
        try {
            jobRunner.runJob();
            return "Job executed successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Job execution failed: " + e.getMessage();
        }
    }
}

