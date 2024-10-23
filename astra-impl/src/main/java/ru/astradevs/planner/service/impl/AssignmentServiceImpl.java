package ru.astradevs.planner.service.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astradevs.planner.dto.AssignmentDto;
import ru.astradevs.planner.exception.NotFoundException;
import ru.astradevs.planner.mapper.AssignmentMapper;
import ru.astradevs.planner.service.AssignmentService;
import ru.astradevs.planner.model.entity.Assignment;
import ru.astradevs.planner.repository.AssignmentRepository;

/**
 * Реализация сервиса для работы с {@linkplain Assignment}
 *
 * @author Pavel Zhykhar
 */
@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository repository;
    private final AssignmentMapper mapper;

    /**
     * Поиск данных о {@link Assignment} задаче по id
     *
     * @param assignmentId id задачи в формате UUID
     * @return Объект {@link AssignmentDto}, содержащий данные о найденной задаче
     * @throws NotFoundException Если задача с указанным id не найдена
     */
    @Override
    public AssignmentDto findAssignmentById(UUID assignmentId) {
        return repository.findById(assignmentId)
            .map(mapper::mapToDto)
            .orElseThrow(() -> new NotFoundException("Assignment not found"));
    }

    /**
     * Поиск всех существующих задач {@link Assignment}
     *
     * @return Список объектов {@link AssignmentDto}, содержащих данные о всех найденных задачах
     */
    @Override
    public List<AssignmentDto> findAll() {
        return repository.findAll().stream()
            .map(mapper::mapToDto)
            .collect(Collectors.toList());
    }

    /**
     * Создание новой задачи {@link Assignment}
     *
     * @param assignmentDto Данные для создания новой задачи в виде {@link AssignmentDto}
     * @return Объект {@link AssignmentDto}, содержащий данные о созданной задаче
     */
    @Override
    @Transactional
    public AssignmentDto createAssignment(AssignmentDto assignmentDto) {
        return Optional.of(assignmentDto)
            .map(mapper::mapToEntity)
            .map(repository::save)
            .map(mapper::mapToDto)
            .orElseThrow();
    }

    /**
     * Удаление задачи {@link Assignment} по id
     *
     * @param id id задачи в формате UUID
     * @return true, если задача успешно удалена, иначе false, если задача с таким id не найдена
     */
    @Override
    @Transactional
    public boolean delete(UUID id) {
        return repository.findById(id)
            .map(entity -> {
                repository.delete(entity);
                repository.flush();
                return true;
            })
            .orElse(false);
    }
}
