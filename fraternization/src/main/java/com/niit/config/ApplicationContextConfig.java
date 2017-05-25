package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// im commenting.....
@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig 
{
	@Bean("dataSource")
	public DataSource getH2DataSource()
	{
			System.out.println("i am in datasource");
	
			BasicDataSource datasource = new BasicDataSource();
			datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			datasource.setUsername("secondp");
			datasource.setPassword("password");
			return datasource;
	
	}
	
	@Autowired
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource)
	{
		System.out.println("i am in local session factory");
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(new String[] {"com.niit.domain"});
		/*
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.setProperties(getHibernateProperties());
		sessionFactory.scanPackages("com.niit.domain");
		return sessionFactory..buildSessionFactory();
		*/
		
		
		return sessionFactory;
	}
	public Properties getHibernateProperties()
	{
		System.out.println("i am in hibernate properties");
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	@Autowired
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("i am in transaction mgr");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}



}
