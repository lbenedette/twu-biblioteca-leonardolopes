package com.twu.biblioteca;

import java.io.PrintStream;

public class GreetingPrinter {
    private final PrintStream printStream;

    public GreetingPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void greeting() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
