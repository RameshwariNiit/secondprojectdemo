package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDao;
import com.niit.domain.UserDomain;

@RestController
public class UserRestController 
{

	@Autowired
	UserDao userDao;

	@GetMapping(value="/user/")
	public ResponseEntity<List<UserDomain>>  listAllUsers()
	{
		
        List<UserDomain> users = userDao.listUsers();
  
        if(users.isEmpty()){
            return new ResponseEntity<List<UserDomain>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserDomain>>(users, HttpStatus.OK);

	}
	
	@PostMapping(value = "/usersave/")
    public ResponseEntity<Void> createUser(@RequestBody UserDomain user) {
        System.out.println("Creating User " + user.getUname());
  
        if (userDao.isExistingUser(user)) {
            System.out.println("A User with name " + user.getUname() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        userDao.addUser(user);
  
       
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	@PostMapping("/login")
	public ResponseEntity<UserDomain> loginemail(@RequestBody UserDomain user)
	{
		System.out.println("get the email id :"+user.getEmailid());
		
		UserDomain usere = userDao.getEmailid(user.getEmailid(),user.getPassword());
		if(usere!=null)
		{
		return new ResponseEntity<UserDomain>(usere,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDomain>(user,HttpStatus.UNAUTHORIZED);
		}
	}
	
}
