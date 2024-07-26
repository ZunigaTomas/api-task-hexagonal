package com.hexagonal.todo.application.usecases;

import com.hexagonal.todo.domain.models.AdditionalTaskInfo;
import com.hexagonal.todo.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.todo.domain.ports.out.ExternalServicePort;
import com.hexagonal.todo.domain.ports.out.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
