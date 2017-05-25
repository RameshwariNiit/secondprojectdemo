package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.UserDao;
import com.niit.domain.UserDomain;

public class TestCase {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);


			UserDao userDao = (UserDao)context.getBean("userDao");
			
			UserDomain user =  new UserDomain();
			user.setUname("ramasai");
			user.setContactno("7676789234");
			user.setEmailid("saibaba@gmail.com");
			user.setPassword("mypass123");
			user.setActive(true);
			user.setRole("user");
			userDao.addUser(user);
		System.out.println("successfully record enterd");
	}

}
