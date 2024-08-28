package com.todo.repository;

import com.todo.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
   Optional<Comment> findByTodoId(Long todoId, Long commentId);
}
