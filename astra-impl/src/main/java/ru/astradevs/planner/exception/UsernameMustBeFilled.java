package ru.astradevs.planner.exception;

public class UsernameMustBeFilled extends RuntimeException {
    public UsernameMustBeFilled() {
        super("Username Must Be Filled");
    }
}
