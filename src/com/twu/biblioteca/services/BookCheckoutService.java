package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Service;

public class BookCheckoutService implements Service {
    private BookCollection bookCollection;
    private BookReader bookReader;

    public BookCheckoutService(BookCollection bookCollection, BookReader bookReader) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
    }

    public String getName() {
        return "Checkout book";
    }

    public void call() {
        try {
            Book book = bookCollection.findByTitle(bookReader.read());
            book.checkout();
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
