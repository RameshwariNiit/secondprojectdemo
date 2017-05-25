package com.niit.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.niit.domain.UserDomain;
@Table(name="RegisterJob", schema="secondp")
@Entity
public class RegisterJob 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long jobApplicationId;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private UserDomain user;
	@ManyToOne
	@JoinColumn(name="jobId")
	private Job job;
	
	private Date dateApplied;
	private String remarks;
	private String status;
	
	
	public long getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	public UserDomain getUser() {
		return user;
	}
	public void setUser(UserDomain user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Date getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	


}
