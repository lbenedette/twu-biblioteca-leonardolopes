package com.twu.biblioteca.services;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.ProtectedService;
import com.twu.biblioteca.interfaces.Reader;

import java.io.PrintStream;

public class BookCheckoutService implements ProtectedService {
    private BookCollection bookCollection;
    private Reader bookReader;
    private PrintStream printStream;

    public BookCheckoutService(BookCollection bookCollection, Reader bookReader, PrintStream printStream) {
        this.bookCollection = bookCollection;
        this.bookReader = bookReader;
        this.printStream = printStream;
    }

    public String getName() {
        return "Checkout book";
    }

    public void call() {
        try {
            checkoutBook(bookCollection.findByTitle(bookReader.read()));
        } catch (BookNotFoundException e) {
            printStream.println(e.getMessage());
        }
    }

    private void checkoutBook(Book book) {
        if (book.isAvailable()) {
            book.checkout();
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("Sorry, that book is not available");
        }
    }
}
