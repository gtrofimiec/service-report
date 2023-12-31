package com.myprojects.servicereport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExistsException extends ResponseStatusException {

    public UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "User already exist");
    }

}
