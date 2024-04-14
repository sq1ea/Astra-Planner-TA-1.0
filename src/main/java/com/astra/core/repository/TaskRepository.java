package com.astra.core.repository;

import com.astra.core.dto.task.TaskCreateEdit;
import com.astra.core.dto.task.TaskRead;
import com.astra.core.entity.Task;
import com.astra.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByTitle(String title);
    Task findTaskByOwner (String owner);


}
