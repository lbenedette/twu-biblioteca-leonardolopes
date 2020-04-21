package com.twu.biblioteca.book;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class BookCollection {
    private List<Book> books;

    public BookCollection(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream()
            .filter(Book::isAvailable)
            .collect(Collectors.toList());
    }

    public Book findByTitle(String title) {
        return books.stream()
            .filter(book -> book.getTitle().equals(title))
            .findFirst()
            .orElseThrow(() -> new BookNotFoundException("Book not found!"));
    }
}
