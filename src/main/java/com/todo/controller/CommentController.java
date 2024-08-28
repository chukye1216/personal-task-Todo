package com.todo.controller;

import com.todo.dto.comment.*;
import com.todo.repository.CommentRepository;
import com.todo.repository.TodoRepository;
import com.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return ResponseEntity.ok(commentService.saveComment(todoId, commentSaveRequestDto));
    }

    @GetMapping("/todo/{todoId}/comments")
    public List<CommentSimpleResponseDto> getComments(){
        return commentService.getComments();
    }

    @GetMapping("/todos/{todoId}/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable Long todoId, @PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getComment(todoId, commentId));
    }

    @PutMapping("/todos/{todoId}/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @PathVariable Long todoId,
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequestDto commentUpdateRequestDto
    ){
        return ResponseEntity.ok(commentService.updateComment(todoId,commentId, commentUpdateRequestDto));
    }
    @DeleteMapping("/todos/{todoId}/comments/{commentId}")
    public void deleteComment(@PathVariable Long todoId, @PathVariable Long commentId) {
        commentService.deleteComment(todoId, commentId);
    }

}
