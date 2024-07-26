package com.hexagonal.todo.domain.ports.in;

import com.hexagonal.todo.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
