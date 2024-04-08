package com.ahnaf.todos.dto;

import lombok.*;
import lombok.Builder.Default;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoDTO {
  @Default
  Boolean starred = false;
  @Default
  Boolean completed = false;
  @Default
  String description = "";
}
