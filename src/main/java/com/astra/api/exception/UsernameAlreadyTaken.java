package com.astra.api.exception;

public class UsernameAlreadyTaken extends RuntimeException{
    public UsernameAlreadyTaken() {
        super("Username Already Taken");
    }
}
