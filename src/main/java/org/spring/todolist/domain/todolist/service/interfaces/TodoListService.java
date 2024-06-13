package org.spring.todolist.domain.todolist.service.interfaces;

import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListUpdateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoListService {
  @Transactional
  ResponseEntity<String> create(TodoListCreateRequest dto);

  @Transactional(readOnly = true)
  List<TodoListResponse> read();

  @Transactional
  ResponseEntity<?> delete(Long id);

  @Transactional
  ResponseEntity<?> update(TodoListUpdateRequest dto);
}
