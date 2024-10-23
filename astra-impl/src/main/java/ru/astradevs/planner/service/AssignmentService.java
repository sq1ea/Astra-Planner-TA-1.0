package ru.astradevs.planner.service;

import java.util.List;
import java.util.UUID;
import ru.astradevs.planner.dto.AssignmentDto;
import ru.astradevs.planner.model.entity.Assignment;

/**
 * Сервис для работы с задачами {@link Assignment}.
 */
public interface AssignmentService {

    /**
     * Поиск задачи по ID.
     *
     * @param assignmentId ID задачи.
     * @return Объект {@link AssignmentDto} с данными задачи.
     */
    public AssignmentDto findAssignmentById(UUID assignmentId);

    /**
     * Создание новой задачи.
     *
     * @param taskDto Данные новой задачи.
     * @return Объект {@link AssignmentDto} с данными созданной задачи.
     */
    public AssignmentDto createAssignment(AssignmentDto taskDto);

    /**
     * Удаление задачи по ID.
     *
     * @param id ID задачи.
     * @return true, если задача успешно удалена, иначе false.
     */
    public boolean delete(UUID id);

    /**
     * Поиск всех задач.
     *
     * @return Список объектов {@link AssignmentDto} с данными всех задач.
     */
    public List<AssignmentDto> findAll();
}
