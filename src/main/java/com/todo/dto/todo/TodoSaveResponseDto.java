package com.todo.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {
    private final Long id;
    private final String username;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public TodoSaveResponseDto(
            Long id,
            String username,
            String title,
            String content,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt)
    {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
