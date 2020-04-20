package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;

public class BookCheckoutService implements Service {
    private BookCollection bookCollection;
    private BookReader bookReader;
    private PrintStream printStream;

    public BookCheckoutService(BookCollection bookCollection, BookReader bookReader, PrintStream printStream) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
        this.printStream = printStream;
    }

    public String getName() {
        return "Checkout book";
    }

    public void call() {
        try {
            Book book = bookCollection.findByTitle(bookReader.read());
            book.checkout();
            printStream.println("Thank you! Enjoy the book");
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
