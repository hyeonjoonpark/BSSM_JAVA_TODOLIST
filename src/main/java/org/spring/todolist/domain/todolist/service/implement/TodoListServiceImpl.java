package org.spring.todolist.domain.todolist.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.domain.todolist.TodoList;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.spring.todolist.domain.todolist.repository.TodoListRepository;
import org.spring.todolist.domain.todolist.service.interfaces.TodoListService;
import org.spring.todolist.domain.todolist.types.StatusType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
  private final TodoListRepository todoListRepository;

  @Override
  @Transactional
  public ResponseEntity<String> create(TodoListCreateRequest dto) {
    String title = dto.title();
    String detail = dto.detail();
    LocalDate startDate = dto.startDate();

    if (
      title != null && detail != null &&
        !title.isEmpty() && !detail.isEmpty()
    ) {
      TodoList todoList = TodoList.builder()
        .title(title)
        .detail(detail)
        .status(StatusType.NOT_STARTED)
        .startDate(startDate)
        .build();
      todoListRepository.save(todoList);
    }

    return ResponseEntity.status(200).body("저장에 성공하였습니다");
  }

  @Override
  @Transactional(readOnly = true)
  public List<TodoListResponse> read() {
    List<TodoList> todos = todoListRepository.findAll();
    List<TodoListResponse> responseList = todos.stream()
      .map(
        todo -> TodoListResponse.builder()
          .id(todo.getId())
          .title(todo.getTitle())
          .detail(todo.getDetail())
          .startDate(todo.getStartDate())
          .status(todo.getStatus())
          .build()
      ).collect(Collectors.toList());
    return responseList;
  }
}
