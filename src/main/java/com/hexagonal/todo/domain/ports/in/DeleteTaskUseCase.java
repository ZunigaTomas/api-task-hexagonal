package com.hexagonal.todo.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
