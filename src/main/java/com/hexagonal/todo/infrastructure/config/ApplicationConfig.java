package com.hexagonal.todo.infrastructure.config;

import com.hexagonal.todo.application.services.TaskService;
import com.hexagonal.todo.application.usecases.*;
import com.hexagonal.todo.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.todo.domain.ports.out.ExternalServicePort;
import com.hexagonal.todo.domain.ports.out.TaskRepositoryPort;
import com.hexagonal.todo.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonal.todo.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
          new CreateTaskUseCaseImpl(taskRepositoryPort),
          new DeleteTaskUseCaseImpl(taskRepositoryPort),
          getAdditionalTaskInfoUseCase,
          new RetrieveTaskUseCaseImpl(taskRepositoryPort),
          new UpdateTaskUseCaseImpl(taskRepositoryPort)
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
