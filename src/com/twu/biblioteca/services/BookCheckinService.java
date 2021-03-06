package com.twu.biblioteca.services;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.ProtectedService;
import com.twu.biblioteca.interfaces.Reader;

import java.io.PrintStream;


public class BookCheckinService implements ProtectedService {
    private BookCollection bookCollection;
    private Reader bookReader;
    private PrintStream printStream;

    public BookCheckinService(BookCollection bookCollection, Reader bookReader, PrintStream printStream) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
        this.printStream = printStream;
    }

    public String getName() {
        return "Return a book";
    }

    public void call() {
        try {
            checkinBook(bookCollection.findByTitle(bookReader.read()));
        } catch (BookNotFoundException e) {
            printStream.println(e.getMessage());
        }
    }

    private void checkinBook(Book book) {
        if (!book.isAvailable()) {
            book.checkin();
            printStream.println("Thank you for returning the book");
        } else {
            printStream.println("That is not a valid book to return");
        }
    }
}
