package org.spring.todolist.domain.todolist.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.domain.todolist.TodoList;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.spring.todolist.domain.todolist.repository.TodoListRepository;
import org.spring.todolist.domain.todolist.service.interfaces.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
  private final TodoListRepository todoListRepository;

  @Override
  public ResponseEntity<String> create(TodoListCreateRequest dto) {


    return null;
  }

  @Override
  public List<TodoListResponse> read() {
    List<TodoList> todos = todoListRepository.findAll();
    List<TodoListResponse> responseList = todos.stream()
      .map(
        todo -> TodoListResponse.builder()
          .title(todo.getTitle())
          .detail(todo.getDetail())
          .build()
      ).collect(Collectors.toList());
    return responseList;
  }
}
