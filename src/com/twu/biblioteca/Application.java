package com.twu.biblioteca;

public class Application {
    BookCollection bookCollection;

    public Application(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

    public void run() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        bookCollection.listBooks();
    }

    public BookCollection getBookCollection() {
        return bookCollection;
    }
}
