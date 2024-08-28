package com.todo.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {
    private String username;
    private String title;
    private String content;

}
