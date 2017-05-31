package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.UserDomain;
import javax.persistence.NoResultException;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}



	
	
	public void addUser(UserDomain user) 
	{
		System.out.println("i am in add user dao");
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();

		
	}
	
	public UserDomain getUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		UserDomain user=(UserDomain)session.createQuery("from UserDomain where uname='"+username+"'").getSingleResult();
		
		return user;
	}

	
	public UserDomain getEmailid(String email,String password)
	{
		Session session = sessionFactory.getCurrentSession();
		UserDomain useremail = (UserDomain)session.createQuery("from UserDomain where emailid ='"+email+"' and password='"+password+"'").getSingleResult();
		return useremail;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDomain> listUsers() {
		Session session=sessionFactory.openSession();
		List<UserDomain> users=session.createQuery("from UserDomain").getResultList();
		
		return users;
	}

	
	public boolean isExistingUser(UserDomain user) {
		UserDomain u=null;
		try {
		u=getUserByUsername(user.getUname());
		}catch(NoResultException nre){
			
		}
		if(u!=null)
		{
			return true;
		}
		else
			return false;
	}





	public UserDomain getUserId(int userId) {
		Session session=sessionFactory.getCurrentSession();
		UserDomain user=(UserDomain)session.createQuery("from UserDomain where userId="+userId).getSingleResult();
				return user;

	}

	

}
