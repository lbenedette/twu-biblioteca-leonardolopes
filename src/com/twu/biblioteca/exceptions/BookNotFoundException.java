package com.twu.biblioteca.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
