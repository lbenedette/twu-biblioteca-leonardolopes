package com.twu.biblioteca.exceptions;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
