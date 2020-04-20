package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;


public class BookCheckinService implements Service {
    private BookCollection bookCollection;
    private BookReader bookReader;
    private PrintStream printStream;

    public BookCheckinService(BookCollection bookCollection, BookReader bookReader, PrintStream printStream) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
        this.printStream = printStream;
    }

    public String getName() {
        return "Return a book";
    }

    public void call() {
        try {
            Book book = bookCollection.findByTitle(bookReader.read());
            book.checkin();
            printStream.println("Thank you for returning the book");
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
