package com.techblog.services;

import java.util.List;

import com.techblog.payload.UserDto;

public interface UserServices {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, int uId);

	UserDto getUserById(int userId);

	List<UserDto> getAllUsers();

	void deletUsers(int userId);

}
