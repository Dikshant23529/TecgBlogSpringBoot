package com.techblog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Catagory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;

	@Column(nullable = false, unique = true)
	private String Cname;

	private String cdiscription;

	public Catagory() {
		super();

	}

	public Catagory(int cId, String cname, String cdiscription) {
		super();
		this.cId = cId;
		Cname = cname;
		this.cdiscription = cdiscription;
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

}
