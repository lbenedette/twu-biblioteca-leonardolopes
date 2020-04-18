package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;

    public BookCollection(List<Book> books) {
        this.books = books;
    }

    public String listBooks() {
        StringBuilder bookList = new StringBuilder(String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published"));

        for (Book book : findAvailableBooks()) {
            bookList.append(String.format("%-40s%-40s%-40s\n", book.getFields()));
        }

        return bookList.toString();
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

    public void checkoutBook(String bookTitle) {
        Book book = findByTitle(bookTitle);
        book.checkout();
    }
}
