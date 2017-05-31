package com.niit.dao;

import java.util.List;

import com.niit.domain.BlogDomain;

public interface BlogDao 
{
	public void addBlog(BlogDomain blog);
	public void updateBlog(BlogDomain blog);
	public void deleteBlog(BlogDomain blog);
	public BlogDomain getBlogId(long blogId);
	public List<BlogDomain> listBlogs();
	public List<BlogDomain> listNewBlogs();


}
