package com.niit.dao;

import java.util.List;

import com.niit.domain.UserDomain;

public interface UserDao
{
	public void addUser(UserDomain user);
	public List<UserDomain> listUsers();
	public boolean isExistingUser(UserDomain user);
	public UserDomain getUserByUsername(String username);
	public UserDomain getEmailid(String email,String password);
	/*public void updateUser(UserDomain user);
	public void deleteUser(UserDomain user);

	public List<UserDomain> listUsers(long userId);
	public UserDomain getUserByUserId(long userId);
	
	
	public boolean authenticate(String username, String password);
*/

}
