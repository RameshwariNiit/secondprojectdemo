package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.domain.BlogDomain;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao 
{
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	
	public void addBlog(BlogDomain blog) {
		
		blog.setStatus("New");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(blog);
		tx.commit();
	
		
	}

	public void updateBlog(BlogDomain blog) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
		
		
	}

	public void deleteBlog(BlogDomain blog) {
		
		Session session=sessionFactory.getCurrentSession();
		session.delete(blog);
		
	}

	public BlogDomain getBlogId(long blogId) {
	
		Session session=sessionFactory.getCurrentSession();
		BlogDomain blog=(BlogDomain)session.createQuery("from BlogDomain where blogId="+blogId).getSingleResult();
		
		return blog;


	}

	@SuppressWarnings("unchecked")
	public List<BlogDomain> listBlogs() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<BlogDomain> blogs=session.createQuery("from BlogDomain").getResultList();
		tx.commit();
		
		
		return blogs;

	}

	@SuppressWarnings("unchecked")
	public List<BlogDomain> listNewBlogs() {
		
		
		Session session=sessionFactory.getCurrentSession();
		List<BlogDomain> blogs=session.createQuery("from BlogDomain where status='New'").getResultList();
		
		return blogs;
	
	}

}
