package com.brooks.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brooks.todo.definition.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
