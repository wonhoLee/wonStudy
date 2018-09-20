package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
