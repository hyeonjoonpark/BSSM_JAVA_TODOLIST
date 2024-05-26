package org.spring.todolist.domain.todolist.presentation.dto.response;

import lombok.Builder;

@Builder
public record TodoListResponse(
  String title,
  String detail
) {

}
