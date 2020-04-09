package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    BookCollection bookCollection;
    private BufferedReader bufferedReader;

    public Application(BookCollection bookCollection, BufferedReader bufferedReader) {
        this.bookCollection = bookCollection;
        this.bufferedReader = bufferedReader;
    }

    public void printGreeting() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printMenu() {
        System.out.println("MENU");
        System.out.println("1 - List of books");
        System.out.println();
        System.out.println("Enter a option:");
    }

    public void readOption() {
        String option = null;
        try {
            option = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ("1".equals(option)) {
            bookCollection.listBooks();
        }
    }

    public void run() {
        printGreeting();
        printMenu();
    }
}
