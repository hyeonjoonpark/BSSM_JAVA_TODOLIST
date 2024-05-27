package org.spring.todolist.domain.todolist.presentation.dto.request;

import java.time.LocalDate;

public record TodoListCreateRequest(
  String title,
  String detail,
  LocalDate startDate
) {

}
