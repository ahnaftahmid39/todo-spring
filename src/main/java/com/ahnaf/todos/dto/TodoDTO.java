package com.ahnaf.todos.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TodoDTO {
  Long id;
  Boolean starred;
  Boolean completed;
  String description;
}
