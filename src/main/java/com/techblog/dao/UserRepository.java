package com.techblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techblog.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
