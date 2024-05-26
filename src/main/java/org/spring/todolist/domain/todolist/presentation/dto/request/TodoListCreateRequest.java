package org.spring.todolist.domain.todolist.presentation.dto.request;

import org.spring.todolist.domain.todolist.types.StatusType;

public record TodoListCreateRequest(
  String title,
  String detail
) {

}
