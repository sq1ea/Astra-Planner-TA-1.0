package ru.astradevs.planner.mapper;

import org.mapstruct.Mapper;
import ru.astradevs.planner.dto.AssignmentDto;
import ru.astradevs.planner.model.entity.Assignment;

/**
 * Маппер для преобразования объектов между сущностью {@linkplain Assignment} и DTO {@linkplain AssignmentDto}
 *
 * @author Pavel Zhykhar
 */
@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    /**
     * Преобразование сущности {@link Assignment} в DTO {@link AssignmentDto}
     *
     * @param assignment объект задачи для преобразования
     * @return объект {@link AssignmentDto}, содержащий данные задачи
     */
    AssignmentDto mapToDto(Assignment assignment);

    /**
     * Преобразование DTO {@link AssignmentDto} в сущность {@link Assignment}
     *
     * @param dto объект задачи для преобразования
     * @return объект {@link Assignment}, содержащий данные задачи
     */
    Assignment mapToEntity(AssignmentDto dto);
}
