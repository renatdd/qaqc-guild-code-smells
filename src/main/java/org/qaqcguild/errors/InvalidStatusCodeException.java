package org.qaqcguild.errors;

public class InvalidStatusCodeException extends RuntimeException {
    public InvalidStatusCodeException() {
        super("Invalid status code");
    }
}
