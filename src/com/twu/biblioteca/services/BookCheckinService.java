package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Service;


public class BookCheckinService implements Service {
    private BookCollection bookCollection;
    private BookReader bookReader;

    public BookCheckinService(BookCollection bookCollection, BookReader bookReader) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
    }

    public String getName() {
        return "Return a book";
    }

    public void call() {
        try {
            Book book = bookCollection.findByTitle(bookReader.read());
            book.checkin();
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
