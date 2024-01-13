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
import com.techblog.payload.CatagoryDto;
import com.techblog.services.impl.CatagoryServiceImpl;

@RestController
@RequestMapping("/apis/catagory")
public class CatagoryControllers {

	@Autowired
	private CatagoryServiceImpl catagoryServiceImpl;

	@PostMapping("/")
	public ResponseEntity<CatagoryDto> createCatagory(@RequestBody CatagoryDto catagoryDto) {
		return new ResponseEntity<CatagoryDto>(this.catagoryServiceImpl.createCatagory(catagoryDto),
				HttpStatus.CREATED);
	}

	@PutMapping("/{cid}")
	public ResponseEntity<CatagoryDto> updateCatagory(@PathVariable("cid") int cid,
			@RequestBody CatagoryDto catagoryDto) {
		return new ResponseEntity<CatagoryDto>(this.catagoryServiceImpl.updateCatagory(catagoryDto, cid),
				HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getAllCatagory() {
		return new ResponseEntity<List<CatagoryDto>>(this.catagoryServiceImpl.getAllCatagory(), HttpStatus.OK);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<?> deleteCatagory(@PathVariable("cid") int cid) {

		return ResponseEntity.ok(Map.of("message", "User deleted successfully"));

	}
}
