package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection(books());
        Application app = new Application(bookCollection, new BufferedReader(new InputStreamReader(System.in)));

        app.run();
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        return books;
    }
}
