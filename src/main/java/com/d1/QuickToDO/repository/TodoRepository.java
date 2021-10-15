package com.d1.QuickToDO.repository;

import com.d1.QuickToDO.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
