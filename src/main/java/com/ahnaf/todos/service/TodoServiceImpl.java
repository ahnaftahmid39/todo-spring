package com.ahnaf.todos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ahnaf.todos.dto.TodoDTO;
import com.ahnaf.todos.model.TodoModel;
import com.ahnaf.todos.repositorie.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
  private final TodoRepository todoRepository;

  TodoServiceImpl(TodoRepository _todoRepository) {
    this.todoRepository = _todoRepository;
  }

  @Override
  public List<TodoDTO> getAllTodos() {
    return todoRepository.findAll()
        .stream()
        .sorted((a, b) -> (int) (a.getId() - b.getId()))
        .map((t) -> t.getTodoDTO())
        .collect(Collectors.toList());
  }

  @Override
  public TodoDTO createTodo(TodoDTO todoDTO) {
    todoRepository.save(new TodoModel(todoDTO));
    return todoDTO;
  }

  @Override
  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }

  @Override
  public TodoDTO getTodo(Long id) {
    Optional<TodoModel> todo = todoRepository.findById(id);
    return todo.isPresent() ? todo.get().getTodoDTO() : null;
  }

  @Override
  public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
    var todoModel = new TodoModel(todoDTO);
    todoModel.setId(id);
    todoRepository.save(todoModel);
    return todoDTO;
  }

}
