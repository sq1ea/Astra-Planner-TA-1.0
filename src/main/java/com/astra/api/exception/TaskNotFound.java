package com.astra.api.exception;

public class TaskNotFound extends RuntimeException{
    public TaskNotFound() {
        super("Could not found task");
    }
}
