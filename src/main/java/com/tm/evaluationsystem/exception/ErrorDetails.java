package com.tm.evaluationsystem.exception;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ErrorDetails {

    private String timestamp;
    private String message;
    private String details;
}