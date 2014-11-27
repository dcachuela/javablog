package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
}
