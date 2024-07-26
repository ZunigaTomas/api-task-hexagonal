package com.hexagonal.todo.application.usecases;

import com.hexagonal.todo.domain.models.Task;
import com.hexagonal.todo.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.todo.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;
    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
