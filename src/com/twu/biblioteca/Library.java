package com.twu.biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    private void greetingMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private void bookList() {
        if (!books.isEmpty()) {
            System.out.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");
        }

        for (Book book : books) {
            System.out.format("%-40s%-40s%-40s\n", book.getFields());
        }
    }

    public void run() {
        greetingMessage();
        bookList();
    }
}
