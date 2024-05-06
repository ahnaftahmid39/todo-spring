package com.ahnaf.todos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahnaf.todos.dto.TodoDTO;
import com.ahnaf.todos.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(value = { "/", "" })
public class TodoController {
  @Autowired
  private TodoService todoService;

  @GetMapping(value = { "/", "" })
  public String getTodos(Model model) {
    model.addAttribute("todos", todoService.getAllTodos());
    return "pages/index";
  }

  @PostMapping(value = { "/", "" })
  public String createTodo(@ModelAttribute TodoDTO todo, Model model) {
    if (todo.getCompleted() == null)
      todo.setCompleted(false);
    if (todo.getStarred() == null)
      todo.setStarred(false);

    var createdTodo = todoService.createTodo(todo);
    model.addAttribute("todo", createdTodo);
    return "custom-responses/todo-add :: todo-add-response";
  }

  @PostMapping(value = { "/update/{id}" }, headers = "hx-request=true")
  public String updateTodo(@PathVariable("id") Long id, @ModelAttribute TodoDTO updatedTodo, Model model) {
    var currentTodo = todoService.getTodo(id);
    if (currentTodo == null)
      return "error";
    if (updatedTodo.getCompleted() != null)
      currentTodo.setCompleted(updatedTodo.getCompleted());
    if (updatedTodo.getStarred() != null)
      currentTodo.setStarred(updatedTodo.getStarred());
    todoService.updateTodo(id, currentTodo);

    model.addAttribute("todo", currentTodo);
    return "components/todo/todo-list-item :: todo-item";
  }

  @DeleteMapping(value = { "/delete/{id}" }, headers = "hx-request=true")
  public String deleteTodo(@PathVariable("id") Long id) {
    var todo = todoService.getTodo(id);
    if (todo == null)
      return "error";
    todoService.deleteTodo(id);
    return "components/utils/utils :: empty";
  }

}
