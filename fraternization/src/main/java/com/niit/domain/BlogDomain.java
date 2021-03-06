package com.niit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name="BlogDomain", schema="secondp")
@Entity
public class BlogDomain
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long blogId;
	
	@Size(min=5, max=50, message="Blog Title should be 5 - 50 characters.")
	private String title;
	@Size(min=5, max=1000, message="Blog Description should be 5 - 1000 characters.")
	private String description;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private UserDomain user;
	private String status;
	
	
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserDomain getUser() {
		return user;
	}
	public void setUser(UserDomain  user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
