package com.reharsh.jobapp.job.serviceinterface;

import com.reharsh.jobapp.job.model.Job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public void createJob(Job job);

    public Job getJobById(long id);
    public boolean deleteJobById(long id);
    public boolean updateJobById(long id,Job updatedJob);

}
