package org.qaqcguild.errors;

public class InvalidToppingCodeException extends RuntimeException {
    public InvalidToppingCodeException() {
        super("Invalid pizza topping code");
    }
}
