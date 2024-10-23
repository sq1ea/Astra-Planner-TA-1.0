package ru.astradevs.planner.controller;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.astradevs.planner.dto.AssignmentDto;
import ru.astradevs.planner.service.AssignmentService;
import ru.astradevs.planner.model.entity.Assignment;

/**
 * Контроллер для {@linkplain Assignment полисов}
 *
 * @author Pavel Zhykhar
 */
@RestController
@RequestMapping("/api/v1/property-service")
@RequiredArgsConstructor
@Tag(name = "AssignmentController", description = "Контроллер для работы с тасками " +
"Общая информация: " +
"Контроллер могут только аутентифицированные пользователи" +
"Отредактировать или удалить таску может только ее создатель" +
"Оставить комментарий или назначить ответственных за ее выполнение можно при создании или при редактировании")
public class AssignmentController {

    /**
     * Сервис для работы с задачами
     */
    private final AssignmentService service;

    /**
     * Поиск задачи по ID
     *
     * @param assignmentId уникальный идентификатор задачи в формате UUID
     * @return {@link ResponseEntity}, содержащий {@link AssignmentDto} с данными задачи, если она найдена
     */
    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<AssignmentDto> findAssignmentById(@PathVariable("assignmentId") UUID assignmentId) {
        return ResponseEntity.ok(service.findAssignmentById(assignmentId));
    }

    /**
     * Создание новой задачи
     *
     * @param assignmentDto объект с данными задачи
     * @return {@link ResponseEntity}, содержащий созданный {@link AssignmentDto}
     */
    @PostMapping("/assignment")
    public ResponseEntity<AssignmentDto> createAssignment(@RequestBody AssignmentDto assignmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAssignment(assignmentDto));
    }

    /**
     * Удаление задачи по ID
     *
     * @param id уникальный идентификатор задачи в формате UUID
     * @return {@link ResponseEntity}, содержащий результат удаления (успешно или нет)
     */
    @DeleteMapping("/assignment/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable("id") UUID id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Получение списка всех задач
     *
     * @return {@link ResponseEntity}, содержащий список всех задач в виде {@link List <AssignmentDto>}
     */
    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentDto>> findAllAssignments() {
        return ResponseEntity.ok(service.findAll());
    }
}
