package com.todo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String content;

    @OneToMany(mappedBy = "Todo")
    private List<Comment> comments = new ArrayList<>();

    public Todo(
            String username,
            String title,
            String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
