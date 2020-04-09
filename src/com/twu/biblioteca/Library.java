package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<String> books;

    public Library(List<String> books) {
        this.books = books;
    }

    private void greetingMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private void bookList() {
        for (String book : books) {
            System.out.println(book);
        }
    }

    public void run() {
        greetingMessage();
        bookList();
    }
}
