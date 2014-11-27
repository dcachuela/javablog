package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
