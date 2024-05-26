package org.spring.todolist.domain.todolist;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.spring.todolist.domain.todolist.types.StatusType;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String detail;
  @Column(columnDefinition = "varchar(255) default 'NOT_STARTED'")
  @Enumerated(EnumType.STRING)
  private StatusType status;
  @CreationTimestamp
  private LocalDate startDate = LocalDate.now();

  @Builder
  public TodoList(Long id, String title, String detail, StatusType status, LocalDate startDate) {
    this.id = id;
    this.title = title;
    this.detail = detail;
    this.status = status;
    this.startDate = startDate;
  }
}
