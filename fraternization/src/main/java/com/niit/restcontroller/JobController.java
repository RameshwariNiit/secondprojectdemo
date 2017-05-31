package com.niit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDao;
import com.niit.domain.Job;

@RestController
public class JobController {
	
	@Autowired
	JobDao jobDao;
	
	@PostMapping("/jobposting")
	public ResponseEntity<Job> jobPosting(@RequestBody Job job)
	{
		jobDao.add(job);
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

}
