package com.twu.biblioteca;

import com.twu.biblioteca.services.BookListService;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        BookCollection bookCollection = new BookCollection(books());
        BookListService bookListService = new BookListService(bookCollection, printStream);

        Menu menu = new Menu();
        menu.addService("1", bookListService);

        bookListService.call();
        printStream.print(menu);
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        return books;
    }
}
