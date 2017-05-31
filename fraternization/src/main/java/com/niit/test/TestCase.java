package com.niit.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.BlogDao;
import com.niit.dao.JobDao;
import com.niit.dao.UserDao;
import com.niit.domain.BlogDomain;
import com.niit.domain.Job;
import com.niit.domain.UserDomain;

public class TestCase {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);


			UserDao userDao = (UserDao)context.getBean("userDao");
			
			/*UserDomain user =  new UserDomain();
			user.setUname("ramasai");
			user.setContactno("7676789234");
			user.setEmailid("saibaba@gmail.com");
			user.setPassword("mypass123");
			user.setActive(true);
			user.setRole("user");
			userDao.addUser(user);*/
			
			/*JobDao jobdao = (JobDao) context.getBean("jobdao");
			Job job = new Job();
			job.setTitle("sanjay");
			job.setDescription("developer role");
			job.setQualification("BE-IT,CSC");
			job.setDated(new Date());
			job.setStatus("available");
			jobdao.add(job);*/
		
			BlogDao blogDao = (BlogDao)context.getBean("blogDao");
			BlogDomain blog = new BlogDomain();
			blog.setTitle("about angular project");
			blog.setDescription("angular frame work with rest controller");
			blog.setUser(userDao.getUserId(3));
			blogDao.addBlog(blog);
			
			
			System.out.println("successfully record enterd");
	}

}
