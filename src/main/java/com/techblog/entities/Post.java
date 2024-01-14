package com.techblog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	private String ptitle;

	private String pdiscription;

	private String image;

	@ManyToOne
	private Catagory catagory;

	@ManyToOne
	private User user;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int pId, String ptitle, String pdiscription, String image, Catagory catagory, User user) {
		super();
		this.pId = pId;
		this.ptitle = ptitle;
		this.pdiscription = pdiscription;
		this.image = image;
		this.catagory = catagory;
		this.user = user;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
