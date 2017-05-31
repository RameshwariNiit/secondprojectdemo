package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.Job;

@Repository("jobdao")
public class JobDaoImpl  implements JobDao
{
	
	@Autowired(required = true)
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}


	public List<Job> list() {
	
		String hql = "from Job";

		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Job> list = (List<Job>) query.list();

		return list;

	}

	@SuppressWarnings("deprecation")
	public Job get(int id) {
		Session session=sessionFactory.getCurrentSession();
		Job job=(Job)session.createQuery("from Job where jobId="+id).getSingleResult();
		return job;

	}

	public void add(Job job) {

		System.out.println("i am in add job dao");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(job);
		tx.commit();

	}

	public void delete(int id) {
		Job job = new Job();
		job.setJobId(id);
		sessionFactory.getCurrentSession().delete(job);
		
	}

}
