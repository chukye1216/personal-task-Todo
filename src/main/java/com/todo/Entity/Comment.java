package com.todo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String username,String comment, Todo todo) {
        this.username = username;
        this.comment = comment;
        this.todo = todo;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
