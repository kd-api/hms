package com.krushidj.hms.modules.exception;

/**
 * Created by Anil D. Ingle on 15-03-2019.
 */
public class EntityViolationException extends RuntimeException {

    public EntityViolationException(String message) {
        super(message);
    }

    public EntityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
