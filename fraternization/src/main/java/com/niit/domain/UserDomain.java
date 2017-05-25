package com.niit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Table(name="UserDomain", schema="secondp")
@Entity
public class UserDomain 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	@Size(min=5, max=10, message="Your name should be between 5 - 10 characters.")
	private String uname;
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String emailid;
	@Size(min=10, message="You cannot entered lessthan 10 digits.")
	private String contactno;
	@NotNull(message="Please select a password")
	 @Length(min=5, max=10, message="Password should be between 5 - 10 charactes")
	private String password;
	private String role;
	private boolean isActive;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	

}
