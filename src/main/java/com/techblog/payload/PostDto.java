package com.techblog.payload;


public class PostDto {

	private String ptitle;

	private String pdiscription;

	private String image;

	private CatagoryDto catagory;

	private UserDto user;

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public String getPdiscription() {
		return pdiscription;
	}

	public void setPdiscription(String pdiscription) {
		this.pdiscription = pdiscription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CatagoryDto getCatagory() {
		return catagory;
	}

	public void setCatagory(CatagoryDto catagory) {
		this.catagory = catagory;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
