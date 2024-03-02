package com.reharsh.jobapp.job.controller;

import com.reharsh.jobapp.job.model.Job;
import com.reharsh.jobapp.job.serviceinterface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService service;
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        service.createJob(job);
        return new ResponseEntity<>("Job Added", HttpStatus.OK);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable long id){
        Job job =service.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
         boolean  status = service.deleteJobById(id);
         if(status)
            return ResponseEntity.ok("Deleted");
         else
             return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateById(@PathVariable long id ,@RequestBody Job updatedJob){
        boolean status  = service.updateJobById(id,updatedJob);
        if(status)
            return ResponseEntity.ok("Updated");
        else
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }
}
