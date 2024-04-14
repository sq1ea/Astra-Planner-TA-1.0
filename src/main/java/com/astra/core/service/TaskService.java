package com.astra.core.service;

import com.astra.core.common.Status;
import com.astra.core.dto.task.TaskCreateEdit;
import com.astra.core.dto.task.TaskRead;
import com.astra.core.entity.Task;
import com.astra.core.mapper.task.TaskCreateEditMapper;
import com.astra.core.mapper.task.TaskReadMapper;
import com.astra.core.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskReadMapper taskReadMapper;
    private final TaskCreateEditMapper taskCreateEditMapper;

    public TaskService(TaskRepository repository, TaskReadMapper taskReadMapper, TaskCreateEditMapper taskCreateEditMapper) {
        this.repository = repository;
        this.taskReadMapper = taskReadMapper;
        this.taskCreateEditMapper = taskCreateEditMapper;
    }
    public List<TaskRead> findAll() {
        return repository.findAll().stream()
                .map(taskReadMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<TaskRead> findById(Integer id) {
        return repository.findById(id)
                .map(taskReadMapper::map);
    }
    public Optional<TaskRead> findByTitle(String title) {
        return repository.findByTitle(title)
                .map(taskReadMapper::map);
    }
    @Transactional
    public TaskRead create(TaskCreateEdit taskDto) {
        return Optional.of(taskDto)
                .map(taskCreateEditMapper::map)
                .map(repository::save)
                .map(taskReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<TaskRead> update(Integer id, TaskCreateEdit taskDto) {
        return repository.findById(id)
                .map(entity -> {
                    return taskCreateEditMapper.map(taskDto, entity);
                })
                .map(repository::saveAndFlush)
                .map(taskReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    repository.flush();
                    return true;
                })
                .orElse(false);
    }

}
