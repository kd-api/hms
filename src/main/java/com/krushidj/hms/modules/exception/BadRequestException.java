package com.hms.modules.exception;

import java.io.Serializable;

/**
 * Use for holding the bad request related exceptions
 */
public class BadRequestException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -6343319438521916333L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}