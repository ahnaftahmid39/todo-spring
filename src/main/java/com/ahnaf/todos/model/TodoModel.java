package com.ahnaf.todos.model;

import com.ahnaf.todos.dto.TodoDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
public class TodoModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "todo_sequence")
  @SequenceGenerator(name = "todo_sequence", sequenceName = "todo_sequence", allocationSize = 1)
  private Long id;

  @Column
  private Boolean starred = false;

  @Column
  private Boolean completed = false;

  @Column
  private String description = "";

  public TodoDTO getTodoDTO() {
    var dto = new TodoDTO();
    dto.setCompleted(getCompleted());
    dto.setId(getId());
    dto.setStarred(getStarred());
    dto.setDescription(getDescription());
    return dto;
  }

  public TodoModel(TodoDTO dto) {
    this.setStarred(dto.getStarred());
    this.setCompleted(dto.getCompleted());
    this.setDescription(dto.getDescription());
  }
}
