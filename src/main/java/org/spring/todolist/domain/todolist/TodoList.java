package org.spring.todolist.domain.todolist;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spring.todolist.domain.todolist.types.StatusType;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String detail;
  private StatusType status;

  @Builder
  public TodoList(Long id, String title, String detail, StatusType status) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.status = status;
  }
}
