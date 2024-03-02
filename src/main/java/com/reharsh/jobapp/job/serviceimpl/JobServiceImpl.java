package com.reharsh.jobapp.job.serviceimpl;

import com.reharsh.jobapp.job.model.Job;
import com.reharsh.jobapp.job.repository.JobRepository;
import com.reharsh.jobapp.job.serviceinterface.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository repo;
    @Override
    public List<Job> findAll() {
        return repo.findAll();
    }

    @Override
    public void createJob(Job job) {
        repo.save(job);
    }

    @Override
    public Job getJobById(long id) {
        Job job = repo.findById(id).orElse(null);
        return job;
    }

    @Override
    public boolean deleteJobById(long id)  {
        try {
            repo.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(long id,Job updatedJob) {
        Optional<Job> optionalJob = repo.findById(id);
        if(optionalJob.isPresent()){
            Job job = optionalJob.get();
                job.setDescription(updatedJob.getDescription());
                job.setTitle(updatedJob.getTitle());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                repo.save(job);
                return true;
            }
        return false;
    }
}
