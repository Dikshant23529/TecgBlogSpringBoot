package com.techblog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techblog.dao.UserRepository;
import com.techblog.entities.User;
import com.techblog.exceptions.ResourceNotFoundException;
import com.techblog.payload.UserDto;
import com.techblog.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);

		User savedUser = this.userRepository.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int uId) {

		User user = this.userRepository.findById(uId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "Id", uId));
		user.setPassword(userDto.getPassword());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepository.save(user);
		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(int userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		UserDto userDto2 = this.userToDto(user);
		return userDto2;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deletUsers(int userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		this.userRepository.delete(user);
	}

	private User dtoToUser(UserDto userDto) {

//		User user = new User();
		User user = this.modelMapper.map(userDto, User.class);

		/*
		 * user.setuId(userDto.getuId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */

		return user;

	}

	private UserDto userToDto(User user) {

//		UserDto userDto = new UserDto();

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		/*
		 * userDto.setuId(user.getuId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setPassword(user.getPassword());
		 * userDto.setAbout(user.getAbout());
		 */

		return userDto;
	}

}
