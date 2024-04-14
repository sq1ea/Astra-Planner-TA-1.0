package com.astra.api.exception;

public class TaskAlreadyExist extends RuntimeException{
    public TaskAlreadyExist() {
        super("Task already exist");
    }

}
