package ru.astradevs.planner.model.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.astradevs.planner.model.enums.Status;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {

    /**
     * Уникальный идентификатор задачи в формате UUID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Статус задачи, сохраняется в виде именованного перечисления в базе данных
     */
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private Status status;

    /**
     * Заголовок задачи
     */
    private String title;

    /**
     * Текстовое описание задачи
     */
    private String text;

    /**
     * Комментарии к задаче. Сохраняются в отдельной таблице users_comments
     */
    @ElementCollection
    @CollectionTable(name = "users_comments", joinColumns =
    @JoinColumn(name = "comment_id"))
    @Column(name = "comment")
    private Set<String> comments;

    /**
     * Ответственные за выполнение задачи пользователи. Сохраняются в отдельной таблице `responsible_users`
     */
    @ElementCollection
    @CollectionTable(name = "responsible_users", joinColumns =
    @JoinColumn(name = "responsible_id"))
    @Column(name = "username")
    private Set<String> usernames;

    /**
     * Дата и время создания задачи.
     */
    private LocalDateTime createdAt;

    /**
     * Дата и время последнего обновления задачи.
     */
    private LocalDateTime updatedAt;
}

