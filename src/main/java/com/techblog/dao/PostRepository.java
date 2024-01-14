package com.techblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techblog.entities.Catagory;
import com.techblog.entities.Post;
import com.techblog.entities.User;

import java.util.*;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCatagory(Catagory catagory);
	
	
}
