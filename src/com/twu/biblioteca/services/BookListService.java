package com.twu.biblioteca.services;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.interfaces.Service;

import java.io.PrintStream;

public class BookListService implements Service {
    private BookCollection bookCollection;
    private PrintStream printStream;

    public BookListService(BookCollection bookCollection, PrintStream printStream) {
        this.bookCollection = bookCollection;
        this.printStream = printStream;
    }

    public String getName() {
        return "List of books";
    }

    public void call() {
        printStream.print(listFormat());
    }

    private String listFormat() {
        StringBuilder bookList = new StringBuilder(String.format("%-40s%-40s%-40s\n", "Title", "Author", "Year Published"));

        for (Book book : bookCollection.getAvailableBooks()) {
            bookList.append(String.format("%-40s%-40s%-40s\n", book.getFields()));
        }

        return bookList.toString();
    }
}
