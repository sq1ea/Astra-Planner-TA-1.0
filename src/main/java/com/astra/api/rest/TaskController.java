package com.astra.api.rest;

import com.astra.api.exception.TaskNotFound;
import com.astra.core.common.Status;
import com.astra.core.dto.task.TaskCreateEdit;
import com.astra.core.dto.task.TaskRead;
import com.astra.core.dto.user.UserRead;
import com.astra.core.service.TaskService;
import com.astra.core.service.UserService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "TaskController",
        description = "Контроллер для работы с тасками " +
        "Общая информация: " +
        "Контроллер могут только аутентифицированные пользователи" +
        "Отредактировать или удалить таску может только ее создатель" +
        "Оставить комментарий или назначить ответственных за ее выполнение можно при создании или при редактировании")

public class TaskController {
    private final TaskService service;
    private final UserService userService;
    private final String NO_COMMENTS = "No comment's yet" ;
    private final String NO_USERS = "No responsible users yet";

    public TaskController(TaskService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<TaskRead> create (@Schema(example =
            "   {                                  " +
                    "  \"title\": \"Big Data\","     +
                    "  \"text\": \"Config release\", "
    )
                                        @RequestBody TaskCreateEdit request,
                                        Authentication authentication) {
  Integer id = userService.findByUsername(authentication.getName()).get().getId();

  request.setStatus(Status.NEW);
  request.setOwner(id);
        service.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/ins")
    public ResponseEntity<Void> insert (@RequestBody TaskCreateEdit request,
                                            Authentication authentication) {
        Integer id = userService.findByUsername(authentication.getName()).get().getId();
        request.setStatus(Status.NEW);
        request.setOwner(id);
        service.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id,
                                       @RequestBody TaskCreateEdit task,
                                       Authentication authentication) {

       service.update(id, task).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Integer id,
                                           @RequestBody TaskCreateEdit task,
                                           Authentication authentication) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/current-list-of-users")
    public ResponseEntity<List<UserRead>> currentUsers () {
        return ResponseEntity.ok(new ArrayList<>(userService.findAll()));
    }

    @GetMapping("/current-list")
    public ResponseEntity<List<TaskRead>> findAll (Authentication authentication) {
        return ResponseEntity.ok(new ArrayList<>(service.findAll()));
    }
}
