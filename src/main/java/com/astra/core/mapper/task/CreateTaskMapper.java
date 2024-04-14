package com.astra.core.mapper.task;

import com.astra.core.dto.task.CreateTask;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskMapper {
    private final CreateTask createTask;

    public CreateTaskMapper(CreateTask createTask) {
        this.createTask = createTask;
    }
}
