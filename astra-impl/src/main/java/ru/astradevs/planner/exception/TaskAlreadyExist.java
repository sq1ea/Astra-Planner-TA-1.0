package ru.astradevs.planner.exception;

public class TaskAlreadyExist extends RuntimeException{
    public TaskAlreadyExist() {
        super("Task already exist");
    }
}
