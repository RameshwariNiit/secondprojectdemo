package com.niit.dao;

import java.util.List;

import com.niit.domain.Job;

public interface JobDao
{

	public List<Job> list();
	
	public Job get(int id);

	public void add(Job job);

	public void delete(int id);
	



	
}
