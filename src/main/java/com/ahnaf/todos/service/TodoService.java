package com.ahnaf.todos.service;

import org.springframework.stereotype.Service;

import com.ahnaf.todos.dto.TodoDTO;

@Service
public interface TodoService {
  TodoDTO createTodo(TodoDTO todoDTO);
  TodoDTO getTodo(Long id);
  TodoDTO updateTodo(Long id, TodoDTO todoDTO);
  void deleteTodo(Long id);
  
}