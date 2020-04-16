package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;


public class Application {
    private final BookCollection bookCollection;
    private final BufferedReader bufferedReader;

    public Application(BookCollection bookCollection, BufferedReader bufferedReader) {
        this.bookCollection = bookCollection;
        this.bufferedReader = bufferedReader;
    }

    public void run() {
        String option = "";

        printGreeting();
        printMenu();
        while (!option.equals("0")) {
            option = enterOption();
            executeAction(option);
        }
    }

    public void printGreeting() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void printMenu() {
        System.out.println("MENU");
        System.out.println("1 - List of books");
        System.out.println();
    }

    public String enterOption() {
        System.out.println("Enter a option:");
        return readLine();
    }

    private String readLine() {
        String input = null;
        try {
            input = bufferedReader.readLine(); // 1
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public void executeAction(String option) {
        if ("1".equals(option)) {
            bookCollection.listBooks();
        } else if ("0".equals(option)) {
            return;
        } else {
            System.out.println("Please select a valid option!");
        }
    }
}
