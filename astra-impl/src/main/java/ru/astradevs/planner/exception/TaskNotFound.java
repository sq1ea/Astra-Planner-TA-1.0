package ru.astradevs.planner.exception;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound() {
        super("Could not found task");
    }
}
