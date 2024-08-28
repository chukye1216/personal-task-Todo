package com.todo.service;

import com.todo.Entity.Comment;
import com.todo.Entity.Todo;
import com.todo.dto.comment.*;
import com.todo.repository.CommentRepository;
import com.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("할일이 없습니다."));

        Comment comment = new Comment(
                commentSaveRequestDto.getUsername(),
                commentSaveRequestDto.getComment(),
                todo
        );
        Comment savedComment = commentRepository.save(comment);
        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getUsername(),
                savedComment.getCreatedAt()
        );
    }

    public List<CommentSimpleResponseDto> getComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : comments) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getComment()));
        }
        return dtoList;
    }


    public CommentDetailResponseDto getComment(Long todoId, Long commentId) {
        Comment comment = commentRepository.findByTodoId(todoId, commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없습니다."));
        return new CommentDetailResponseDto(
                comment.getId(),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(
            Long todoId,
            Long commentId,
            CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findByTodoId(todoId, commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없습니다."));
        comment.update(commentUpdateRequestDto.getComment());

        Comment updatedComment = commentRepository.save(comment);

        return new CommentUpdateResponseDto(
                updatedComment.getId(),
                updatedComment.getComment(),
                updatedComment.getModifiedAt()
        );
    }

    @Transactional
    public void deleteComment(Long todoId, Long commentId) {
        Comment comment = commentRepository.findByTodoId(todoId, commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 없습니다."));
        commentRepository.delete(comment);
    }
}
