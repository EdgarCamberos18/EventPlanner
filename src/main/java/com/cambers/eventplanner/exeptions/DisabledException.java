package com.cambers.eventplanner.exeptions;

public class DisabledException extends RuntimeException {
    public DisabledException(String message) {
        super(message);
    }
}