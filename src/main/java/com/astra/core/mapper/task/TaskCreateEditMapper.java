package com.astra.core.mapper.task;

import com.astra.core.dto.task.TaskCreateEdit;
import com.astra.core.entity.Task;
import com.astra.core.entity.User;
import com.astra.core.mapper.Mapper;
import com.astra.core.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class TaskCreateEditMapper implements Mapper <TaskCreateEdit, Task> {
    private final UserRepository repository;

    public TaskCreateEditMapper(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task map(TaskCreateEdit object) {
        Task task = new Task();
        copy(object, task);
        return task;
    }
    @Override
    public Task map(TaskCreateEdit fromObject, Task toObject) {
        copy(fromObject, toObject);
        return toObject;
    }


    private void copy(TaskCreateEdit object, Task task) {
        task.setStatus(object.getStatus());
        task.setTitle(object.getTitle());
        task.setText(object.getText());
        task.setComments(object.getComments());
        task.setOwner(getUser(object.getOwner()));
        task.setUsernames(object.getUsernames());
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
    }

    public User getUser(Integer userId) {
        return Optional.ofNullable(userId)
                .flatMap(repository::findById)
                .orElse(null);
    }



}

