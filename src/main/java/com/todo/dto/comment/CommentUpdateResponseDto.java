package com.todo.dto.comment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateResponseDto {
    private final Long id;
    private final String comment;
    private final LocalDateTime modified;

    public CommentUpdateResponseDto(Long id, String comment, LocalDateTime modified) {
        this.id = id;
        this.comment = comment;
        this.modified = modified;
    }
}
