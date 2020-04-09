package com.twu.biblioteca;

import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection(List<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        if (!books.isEmpty()) {
            System.out.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");
        }

        for (Book book : books) {
            System.out.format("%-40s%-40s%-40s\n", book.getFields());
        }
    }
}
