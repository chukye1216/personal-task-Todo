package com.todo.dto.todo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateRequestDto {
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
