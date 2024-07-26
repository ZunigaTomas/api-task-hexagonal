package com.hexagonal.todo.domain.ports.in;

import com.hexagonal.todo.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
