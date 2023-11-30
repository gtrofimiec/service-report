package com.myprojects.servicereport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReportNotFoundException extends ResponseStatusException {

    public ReportNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Report not found");
    }
}
