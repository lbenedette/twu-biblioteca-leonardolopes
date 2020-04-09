package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Library library = new Library(books);
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        library.run();
    }
}
