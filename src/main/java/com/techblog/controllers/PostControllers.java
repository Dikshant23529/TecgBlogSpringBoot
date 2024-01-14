package com.techblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.techblog.payload.PostDto;
import com.techblog.services.impl.PostServiceImpl;

@RestController
@RequestMapping("apis/post")
public class PostControllers {

	@Autowired
	private PostServiceImpl postServiceImpl;

//	Create Post

	@PostMapping("/user/{uid}/catagory/{cid}/create")
	public ResponseEntity<PostDto> savePost(@PathVariable("uid") int uid, @PathVariable("cid") int cid,
			@RequestBody PostDto postDto) {

		PostDto dto = this.postServiceImpl.createPost(postDto, uid, cid);

		return new ResponseEntity<PostDto>(dto, HttpStatus.CREATED);

	}

//	Update Post
	@PutMapping("/id/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable("id") int id, @RequestBody PostDto dto) {

		PostDto updatePost = this.postServiceImpl.updatePost(dto, id);

		return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
	}

//	Delete Post
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deletePost(@PathVariable("id") int id) {

		this.postServiceImpl.deletePost(id);

		return new ResponseEntity<Object>(Map.of("Message", "User deleted Successfully"), HttpStatus.OK);

	}

//	get All Post

	@GetMapping("/")
	public ResponseEntity<List<PostDto>> getAllPosts() {

		List<PostDto> allPosts = this.postServiceImpl.getAllPosts();

		return new ResponseEntity<List<PostDto>>(allPosts, HttpStatus.OK);
	}

//	Get Post By Id
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable("id") int id) {
		PostDto postById = this.postServiceImpl.getPostById(id);
		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}

//	Get Post By Catagory 
	@GetMapping("/catagory/{id}")
	public ResponseEntity<List<PostDto>> getPostByCatagory(@PathVariable("id") int id) {
		List<PostDto> postByCat = this.postServiceImpl.getPostByCat(id);

		return new ResponseEntity<List<PostDto>>(postByCat, HttpStatus.OK);
	}

//	Get Post By User
	@GetMapping("/user/{id}")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable("id") int id) {
		List<PostDto> postByUser = this.postServiceImpl.getPostByUser(id);
		return new ResponseEntity<List<PostDto>>(postByUser, HttpStatus.OK);
	}

}
