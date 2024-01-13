package com.techblog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techblog.dao.CatagoryRepository;
import com.techblog.entities.Catagory;
import com.techblog.exceptions.ResourceNotFoundException;
import com.techblog.payload.CatagoryDto;
import com.techblog.services.CatagoryServices;

@Service
public class CatagoryServiceImpl implements CatagoryServices {

	@Autowired
	private CatagoryRepository catagoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CatagoryDto createCatagory(CatagoryDto catagoryDto) {

		Catagory cat = this.modelMapper.map(catagoryDto, Catagory.class);
//		
		Catagory saveCat = this.catagoryRepository.save(cat);
//		
		return this.modelMapper.map(saveCat, CatagoryDto.class);

		/*
		 * Catagory catagory = this.dtoToCatagory(catagoryDto);
		 * 
		 * Catagory saveCatagory = this.catagoryRepository.save(catagory);
		 * 
		 * CatagoryDto catagoryDto2 = this.catagorytoDto(saveCatagory);
		 * 
		 * return catagoryDto2;
		 */
	}

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, int cid) {
		Catagory catagory = this.catagoryRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Catagpry", "ID", cid));

		catagory.setCname(catagoryDto.getCname());
		catagory.setCdiscription(catagoryDto.getCdiscription());

		return this.modelMapper.map(catagory, CatagoryDto.class);
	}

	@Override
	public void deleteCatagory(int cid) {
		Catagory cat = this.catagoryRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "Catagory ID", cid));

		this.catagoryRepository.delete(cat);

	}

	@Override
	public List<CatagoryDto> getAllCatagory() {
		List<Catagory> getAllCatagory = this.catagoryRepository.findAll();
		List<CatagoryDto> allcat = getAllCatagory.stream()
				.map(cat -> this.modelMapper.map(getAllCatagory, CatagoryDto.class)).collect(Collectors.toList());
		return allcat;
	}

	/*
	 * private Catagory dtoToCatagory(CatagoryDto dto) {
	 * 
	 * // Catagory cat = this.modelMapper.map(dto, Catagory.class);
	 * 
	 * Catagory cat = new Catagory();
	 * 
	 * cat.setCname(dto.getCname()); cat.setCdiscription(dto.getCdiscription());
	 * 
	 * return cat; }
	 * 
	 * private CatagoryDto catagorytoDto(Catagory catagory) {
	 * 
	 * // CatagoryDto catagoryDtoC = this.modelMapper.map(catagory,
	 * CatagoryDto.class);
	 * 
	 * CatagoryDto dto = new CatagoryDto();
	 * 
	 * dto.setCname(catagory.getCname());
	 * dto.setCdiscription(catagory.getCdiscription());
	 * 
	 * return dto; }
	 * 
	 */

}
