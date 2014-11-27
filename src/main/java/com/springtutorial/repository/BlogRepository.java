package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.entity.Blog;
import com.springtutorial.entity.Role;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	
}
