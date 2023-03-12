package com.ev.evproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private String message;
    private LocalDateTime timestamp;
    public ApiResponse(String message) {
        super();
        this.message = message;
        this.timestamp=LocalDateTime.now();
    }
}
