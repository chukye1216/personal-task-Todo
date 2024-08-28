package com.todo.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String comment;
    private final LocalDateTime createdAt;

    public CommentSaveResponseDto(Long id, String comment, LocalDateTime createdAt) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
    }
}
