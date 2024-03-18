package com.tm.evaluationsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SectionNotFoundException extends Exception {
    public SectionNotFoundException(String message) {
        super(message);
    }
}
