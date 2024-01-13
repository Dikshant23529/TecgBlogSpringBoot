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
import com.techblog.payload.UserDto;
import com.techblog.services.impl.UserServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserControllers

{

	@Autowired
	private UserServicesImpl userServicesImpl;

//	Create --> Post request

	@PostMapping("/")

	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)

	{
		UserDto userDto2 = this.userServicesImpl.createUser(userDto);
		return new ResponseEntity<>(userDto2, HttpStatus.CREATED);
	}

//	Update User --> Update request user 

	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userid") Integer userid) {

		UserDto userDto2 = this.userServicesImpl.updateUser(userDto, userid);
		return new ResponseEntity<UserDto>(userDto2, HttpStatus.OK);
	}

//	Get all users --> Get request

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return ResponseEntity.ok(this.userServicesImpl.getAllUsers());
	}

//	Get User By ID --> Get request by ID 

	@GetMapping("/{UserId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("UserId") Integer UserId) {
		return ResponseEntity.ok(this.userServicesImpl.getUserById(UserId));
	}

//	Delete User --> Delete user request 
	@DeleteMapping("/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable("uid") Integer uid) {
		this.userServicesImpl.deletUsers(uid);
		return new ResponseEntity<Object>(Map.of("message","User deleted successfully"), HttpStatus.OK);
	}

}
