package com.techblog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CatagoryDto {

	private int cId;

	@NotEmpty
	@Size(min = 4, message = "Catagory Name must have the 4 characters")
	private String cname;
	private String cdiscription;

	public CatagoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatagoryDto(int cId, String cname, String cdiscription) {
		super();
		this.cId = cId;
		this.cname = cname;
		this.cdiscription = cdiscription;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdiscription() {
		return cdiscription;
	}

	public void setCdiscription(String cdiscription) {
		this.cdiscription = cdiscription;
	}

}
