package org.spring.todolist.domain.todolist.service.interfaces;

import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoListService {
  ResponseEntity<String> create(TodoListCreateRequest dto);

  List<TodoListResponse> read();
}
