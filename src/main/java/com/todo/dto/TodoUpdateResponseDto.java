package com.todo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateResponseDto {
    private final Long id;
    private final String username;
    private final String title;
    private final String content;
    private final LocalDateTime modifiedAt;

    public TodoUpdateResponseDto(
            Long id,
            String username,
            String title,
            String content,
            LocalDateTime modifiedAt)
    {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.modifiedAt = modifiedAt;
    }
}
