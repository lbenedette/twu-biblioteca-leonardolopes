package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection(List<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        System.out.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published");

        for (Book book : findAvailableBooks()) {
            System.out.format("%-40s%-40s%-40s\n", book.getFields());
        }
    }

    public List<Book> findAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        return null;
    }

    public void checkoutBook(Book book) {
        book.checkout();
    }
}
