package com.techblog.payload;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {

	private int uId;

	@NotEmpty
	@Size(min = 4, message = "Name must have 4 characters")
	private String name;

	@NotEmpty
	@Email(message = "enter a valid email address")
	private String email;

	@NotEmpty
	@Size(min = 8, max = 18, message = "password must have 8 characters")
	private String password;

	private String about;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int uId, String name, String email, String password, String about) {
		super();
		this.uId = uId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

//	public UserDto(BCryptPasswordEncoder bCryptPasswordEncoder, String rawPassword) {
//		this.password = bCryptPasswordEncoder.encode(rawPassword);
//	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(BCryptPasswordEncoder bCryptPasswordEncoder, String rawPassword) {
		this.password = bCryptPasswordEncoder.encode(rawPassword);
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

}
