package com.springtutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
}
