package com.ev.evproject.exceptions;

public class ResourceAlreadyPresentException extends RuntimeException {
    public ResourceAlreadyPresentException(String message) {
        super(message);
    }
}
