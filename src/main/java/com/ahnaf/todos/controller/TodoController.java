package com.ahnaf.todos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @GetMapping(value = "/all")
  public String getTodos() {
    return new String("No todos for now");
  }

}
