package com.astra.core.mapper.task;

import com.astra.core.dto.task.TaskRead;
import com.astra.core.dto.user.UserRead;
import com.astra.core.entity.Task;
import com.astra.core.mapper.Mapper;
import com.astra.core.mapper.user.UserReadMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskReadMapper implements Mapper<Task, TaskRead> {

    private final UserReadMapper userReadMapper;

    public TaskReadMapper(UserReadMapper userReadMapper) {
        this.userReadMapper = userReadMapper;
    }

    @Override
    public TaskRead map(Task object) {

        UserRead user = Optional.ofNullable(object.getOwner())
                .map(userReadMapper::map)
                .orElse(null);


        return new TaskRead(
                object.getId(),
                object.getStatus(),
                object.getTitle(),
                object.getText(),
                object.getComments(),
                user,
                object.getUsernames(),
                object.getCreatedAt(),
                object.getUpdatedAt()
        );
    }
}

