package com.techblog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techblog.services.PostServices;
import com.techblog.dao.CatagoryRepository;
import com.techblog.dao.PostRepository;
import com.techblog.dao.UserRepository;
import com.techblog.entities.Catagory;
import com.techblog.entities.Post;
import com.techblog.entities.User;
import com.techblog.exceptions.ResourceNotFoundException;
import com.techblog.payload.PostDto;

@Service
public class PostServiceImpl implements PostServices {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CatagoryRepository catagoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public PostDto createPost(PostDto postDto, int pid, int cid) {

		Catagory catagory = this.catagoryRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "CatagoryId", cid));

		User user = this.userRepository.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User ID", pid));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setCatagory(catagory);

		post.setUser(user);

		Post savePost = this.postRepository.save(post);

		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, int pid) {

		Post post = this.postRepository.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", pid));

		post.setPtitle(postDto.getPtitle());
		post.setPdiscription(postDto.getPdiscription());

		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public void deletePost(int pid) {
		Post post = this.postRepository.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Delete", "Delete Id", pid));
		this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPosts() {

		List<Post> Posts = this.postRepository.findAll();

		List<PostDto> postsDtos = Posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());

		return postsDtos;
	}

	@Override
	public PostDto getPostById(int pid) {
		Post post = this.postRepository.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Post Id", "Post", pid));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCat(int cid) {

		Catagory cat = this.catagoryRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "CatagoryId", cid));
		List<Post> allPostByCat = this.postRepository.findByCatagory(cat);

		List<PostDto> postDtoList = allPostByCat.stream().map((Post) -> this.modelMapper.map(Post, PostDto.class))
				.collect(Collectors.toList());

		return postDtoList;
	}

	@Override
	public List<PostDto> getPostByUser(int uid) {

		User user = this.userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User Id", "User", uid));

		List<Post> postfindByUser = this.postRepository.findByUser(user);

		List<PostDto> postByUser = postfindByUser.stream()
				.map((userpost) -> this.modelMapper.map(userpost, PostDto.class)).collect(Collectors.toList());

		return postByUser;
	}

}
