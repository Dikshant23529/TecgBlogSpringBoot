package com.techblog.services;

import com.techblog.payload.CatagoryDto;

import java.util.*;

public interface CatagoryServices {

//	create 

	CatagoryDto createCatagory(CatagoryDto catagoryDto);

//	Update 
	CatagoryDto updateCatagory(CatagoryDto catagoryDto, int cid);

//	Delete 
	void deleteCatagory(int cid);

//  get All  
	List<CatagoryDto> getAllCatagory();

}
