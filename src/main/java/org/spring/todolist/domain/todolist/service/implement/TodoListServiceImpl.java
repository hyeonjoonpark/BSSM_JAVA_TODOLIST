package org.spring.todolist.domain.todolist.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.domain.todolist.TodoList;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListUpdateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.spring.todolist.domain.todolist.repository.TodoListRepository;
import org.spring.todolist.domain.todolist.service.interfaces.TodoListService;
import org.spring.todolist.domain.todolist.types.StatusType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
  private final TodoListRepository todoListRepository;

  @Override
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

  @Override
  public ResponseEntity<?> delete(Long id) {
    if (id != 0) {
      todoListRepository.deleteById(id);
    }
    return ResponseEntity.status(200).body("성공적으로 삭제하였습니다");
  }

  @Override
  public ResponseEntity<?> update(TodoListUpdateRequest dto) {
    Optional<TodoList> todoList = todoListRepository.findById(dto.id());

    if (todoList.isPresent()) {
      todoList.get().setTitle(dto.title());
      todoList.get().setDetail(dto.detail());
      todoList.get().setStartDate(dto.startDate());
      todoListRepository.save(todoList.get());
    }

    return ResponseEntity.status(200).body("성공적으로 수정하였습니다");
  }
}
