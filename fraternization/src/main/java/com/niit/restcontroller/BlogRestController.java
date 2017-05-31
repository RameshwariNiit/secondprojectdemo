package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.BlogDao;
import com.niit.dao.UserDao;
import com.niit.domain.BlogDomain;
import com.niit.domain.UserDomain;

@RestController
public class BlogRestController 
{
	
	@Autowired
	BlogDao blogDao;
	
	@Autowired
	UserDao userDao;
	
	//-------------------Retrieve All Blogs--------------------------------------------------------
    
			@GetMapping(value="/blog/")
		    public ResponseEntity<List<BlogDomain>> listAllBlogs() {
		        List<BlogDomain> blogs = blogDao.listBlogs();
		        if(blogs.isEmpty()){
		            return new ResponseEntity<List<BlogDomain>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<List<BlogDomain>>(blogs, HttpStatus.OK);
		    }
			
			//-------------------Retrieve All New Blogs--------------------------------------------------------
		    
			@GetMapping(value="/blog/new")
		    public ResponseEntity<List<BlogDomain>> listAllNewBlogs() {
		        List<BlogDomain> blogs = blogDao.listNewBlogs();
		        if(blogs.isEmpty()){
		            return new ResponseEntity<List<BlogDomain>>(HttpStatus.NO_CONTENT);
		        }
		        return new ResponseEntity<List<BlogDomain>>(blogs, HttpStatus.OK);
		    }
	
	
			
			//-------------------Retrieve Single Blog--------------------------------------------------------
		    
			@GetMapping(value="/blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<BlogDomain> getBlog(@PathVariable("id") long id) {
		        
		        BlogDomain blog = blogDao.getBlogId(id);
		        if (blog == null) {
		            
		            return new ResponseEntity<BlogDomain>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<BlogDomain>(blog, HttpStatus.OK);
		    }
			
			
			//-------------------Create a Blog--------------------------------------------------------
		    
			@PostMapping(value = "/blog/{id}")
		    public ResponseEntity<Void> createBlog(@RequestBody BlogDomain blog,@PathVariable Integer id) {
				
			 UserDomain user=userDao.getUserId(id);
			    blog.setUser(user);
		  
		        blogDao.addBlog(blog);
		  
		       
		        return new ResponseEntity<Void>(HttpStatus.CREATED);
		    }
			
			
			 //------------------- Update a User --------------------------------------------------------
		    
			@PutMapping(value = "/blog/{id}")
		    public ResponseEntity<BlogDomain> updateBlog(@PathVariable("id") long id, @RequestBody BlogDomain blog) {
		      
		          
		        BlogDomain currentBlog = blogDao.getBlogId(id);
		          
		        if (currentBlog==null) {
		            
		            return new ResponseEntity<BlogDomain>(HttpStatus.NOT_FOUND);
		        }
		  
		        currentBlog.setTitle(blog.getTitle());
		        currentBlog.setDescription(blog.getDescription());
		       
		        
		          
		        blogDao.updateBlog(currentBlog);
		        return new ResponseEntity<BlogDomain>(currentBlog, HttpStatus.OK);
		    }
		  
			
			//------------------- Delete a blog --------------------------------------------------------
		    @DeleteMapping(value = "/blog/{id}")
		    public ResponseEntity<BlogDomain> deleteBlog(@PathVariable("id") long id) {
		        		  
		        BlogDomain blog = blogDao.getBlogId(id);
		        if (blog == null) {
		            
		            return new ResponseEntity<BlogDomain>(HttpStatus.NOT_FOUND);
		        }
		  
		        blogDao.deleteBlog(blog);
		        return new ResponseEntity<BlogDomain>(HttpStatus.NO_CONTENT);
		    }
		    
	
//-------------------Approve Blog--------------------------------------------------------
		    
			@GetMapping(value="/approveblog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<BlogDomain> approveBlog(@PathVariable("id") long id) {
		        
		        BlogDomain blog = blogDao.getBlogId(id);
		        
		        if (blog == null) {
		            
		            return new ResponseEntity<BlogDomain>(HttpStatus.NOT_FOUND);
		        }
		        blog.setStatus("Approved");
		        blogDao.updateBlog(blog);
		        return new ResponseEntity<BlogDomain>(blog, HttpStatus.OK);
		    }
			
//-------------------Reject Blog--------------------------------------------------------
		    
			@GetMapping(value="/rejectblog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
		    public ResponseEntity<BlogDomain> rejectBlog(@PathVariable("id") long id) {
		        
		        BlogDomain blog = blogDao.getBlogId(id);
		        
		        if (blog == null) {
		            
		            return new ResponseEntity<BlogDomain>(HttpStatus.NOT_FOUND);
		        }
		        blog.setStatus("Rejected");
		        blogDao.updateBlog(blog);
		        return new ResponseEntity<BlogDomain>(blog, HttpStatus.OK);
		    }
}