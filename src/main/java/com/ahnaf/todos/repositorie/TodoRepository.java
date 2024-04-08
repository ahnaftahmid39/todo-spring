package com.ahnaf.todos.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahnaf.todos.model.TodoModel;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
