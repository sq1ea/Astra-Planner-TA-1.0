package ru.astradevs.planner.advice;

import ru.astradevs.planner.exception.UserNotFoundException;
import ru.astradevs.planner.exception.UsernameAlreadyTaken;
import ru.astradevs.planner.exception.UsernameMustBeFilled;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundUserWithUsername(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UsernameMustBeFilled.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String usernameMustBeFilled(UsernameMustBeFilled ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UsernameAlreadyTaken.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String usernameAlreadyTaken(UsernameAlreadyTaken ex) {return ex.getMessage();}
}


