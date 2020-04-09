package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;


public class Application {
    private BookCollection bookCollection;
    private BufferedReader bufferedReader;

    public Application(BookCollection bookCollection, BufferedReader bufferedReader) {
        this.bookCollection = bookCollection;
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        printGreeting();
        printMenu();
        enterOption();
    }

    public void printGreeting() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printMenu() {
        System.out.println("MENU");
        System.out.println("1 - List of books");
        System.out.println();
    }

    public void enterOption() {
        System.out.println("Enter a option:");
        String option = readLine();
        executeAction(option);
    }

    private String readLine() {
        String input = null;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    private void executeAction(String option) {
        if ("1".equals(option)) {
            bookCollection.listBooks();
        }
    }
}
