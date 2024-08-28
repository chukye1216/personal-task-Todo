package com.todo.service;

import com.todo.Entity.Todo;
import com.todo.dto.todo.*;
import com.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo todo = new Todo(
                todoSaveRequestDto.getUsername(),
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getContent()
        );
        Todo savedTodo = todoRepository.save(todo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getUsername(),
                savedTodo.getTitle(),
                savedTodo.getContent(),
                savedTodo.getCreatedAt(),
                savedTodo.getModifiedAt()
        );
    }
    public TodoDetailResponseDto getTodos(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("할 일이 없습니다."));
        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getUsername(),
                todo.getTitle(),
                todo.getContent(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    public Page<TodoDetailResponseDto> getTodo(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return todos.map(todo -> new TodoDetailResponseDto(
                todo.getId(),
                todo.getUsername(),
                todo.getTitle(),
                todo.getContent(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        ));
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()-> new  IllegalArgumentException("할일이 없습니다."));
        todo.update(
                todoUpdateRequestDto.getTitle(),
                todoUpdateRequestDto.getContent());
        return new TodoUpdateResponseDto
                (
                todo.getId(),
                todo.getUsername(),
                todo.getTitle(),
                todo.getContent(),
                todo.getModifiedAt()
        );
    }

}
