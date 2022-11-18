package com.brooks.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brooks.todo.definition.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
