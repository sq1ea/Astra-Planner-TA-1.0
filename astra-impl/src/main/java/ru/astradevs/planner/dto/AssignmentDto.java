package ru.astradevs.planner.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto {

    private UUID id;

    private String status;

    private String title;

    private String text;

    private Set<String> comments;

    private String owner;

    private Set<String> usernames;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

