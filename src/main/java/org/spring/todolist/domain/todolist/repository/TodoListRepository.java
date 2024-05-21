package org.spring.todolist.domain.todolist.repository;

import org.spring.todolist.domain.todolist.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
