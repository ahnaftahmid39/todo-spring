package com.ahnaf.todos.service;

import java.util.List;

import com.ahnaf.todos.dto.TodoDTO;

public interface TodoService {
  List<TodoDTO> getAllTodos();

  TodoDTO createTodo(TodoDTO todoDTO);

  TodoDTO getTodo(Long id);

  TodoDTO updateTodo(Long id, TodoDTO todoDTO);

  void deleteTodo(Long id);

}