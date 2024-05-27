package org.spring.todolist.domain.todolist.presentation.dto.response;

import lombok.Builder;
import org.spring.todolist.domain.todolist.types.StatusType;

import java.time.LocalDate;

@Builder
public record TodoListResponse(
  Long id,
  String title,
  String detail,
  LocalDate startDate,
  StatusType status
) {

}
