package org.spring.todolist.domain.todolist.presentation;

import lombok.RequiredArgsConstructor;
import org.spring.todolist.domain.todolist.presentation.dto.request.TodoListCreateRequest;
import org.spring.todolist.domain.todolist.presentation.dto.response.TodoListResponse;
import org.spring.todolist.domain.todolist.service.interfaces.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoListController {
  private final TodoListService todoListService;
  @PostMapping("/write")
  public ResponseEntity<String> writeTodo(@RequestBody TodoListCreateRequest dto) {
    ResponseEntity<String> result = todoListService.create(dto);
    return result;
  }

  @GetMapping("/read")
  public List<TodoListResponse> getTodoLists() {
    List<TodoListResponse> responseList = todoListService.read();
    return responseList;
  }
}
