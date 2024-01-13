package com.techblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techblog.entities.Catagory;

public interface CatagoryRepository extends JpaRepository<Catagory, Integer> {

}
