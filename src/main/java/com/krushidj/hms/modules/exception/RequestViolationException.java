package com.krushidj.hms.modules.exception;

public class RequestViolationException extends RuntimeException {
    public RequestViolationException() {
        super();
    }

    public RequestViolationException(String message) {
        super(message);
    }

    public RequestViolationException(String message, Throwable exception) {
        super(message, exception);
    }
}
