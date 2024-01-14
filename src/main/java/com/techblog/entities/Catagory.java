package com.techblog.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;

	@Column(nullable = false, unique = true)
	private String Cname;

	private String cdiscription;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catagory")
	private List<Post> posts;

	public Catagory() {
		super();

	}

	public Catagory(int cId, String cname, String cdiscription, List<Post> posts) {
		super();
		this.cId = cId;
		Cname = cname;
		this.cdiscription = cdiscription;
		this.posts = posts;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCdiscription() {
		return cdiscription;
	}

	public void setCdiscription(String cdiscription) {
		this.cdiscription = cdiscription;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
