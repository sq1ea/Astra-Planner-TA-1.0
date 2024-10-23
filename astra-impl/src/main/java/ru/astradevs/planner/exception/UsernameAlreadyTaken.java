package ru.astradevs.planner.exception;

public class UsernameAlreadyTaken extends RuntimeException{
    public UsernameAlreadyTaken() {
        super("Username Already Taken");
    }
}
