package com.twu.biblioteca;

public class Application {
    BookCollection bookCollection;

    public Application(BookCollection bookCollection) {
        this.bookCollection = bookCollection;
    }

    public void printGreeting() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printMenu() {
        System.out.println("MENU");
        System.out.println("1 - List of books");
    }

    public void run() {
        printGreeting();
        printMenu();
    }
}
