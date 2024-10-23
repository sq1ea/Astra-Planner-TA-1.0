package ru.astradevs.planner.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.astradevs.planner.model.entity.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, UUID> {

}
