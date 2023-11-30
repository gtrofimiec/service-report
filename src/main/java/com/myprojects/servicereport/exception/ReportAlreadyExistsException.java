package com.myprojects.servicereport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReportAlreadyExistsException extends ResponseStatusException {

    public ReportAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "Report already exist");
    }
}
