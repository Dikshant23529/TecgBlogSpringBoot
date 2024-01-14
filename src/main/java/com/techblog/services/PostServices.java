package com.techblog.services;

import com.techblog.payload.PostDto;

import java.util.List;

public interface PostServices {

//	create 	
	PostDto createPost(PostDto postDto, int pid, int cid);

//	update 	
	PostDto updatePost(PostDto postDto, int pid);

//	Delete 
	void deletePost(int pid);

//	Get All
	List<PostDto> getAllPosts();

//	Get By id
	PostDto getPostById(int pid);

//	Get Post By Catagory
	List<PostDto> getPostByCat(int cid);

//	Get Post By User
	List<PostDto> getPostByUser(int uid);

}
