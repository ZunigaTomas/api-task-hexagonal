package com.hexagonal.todo.domain.ports.out;

import com.hexagonal.todo.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
