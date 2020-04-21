package com.twu.biblioteca;

import com.twu.biblioteca.interfaces.Reader;

import java.io.PrintStream;
import java.util.Scanner;

public class InputReader implements Reader {
    private final PrintStream printStream;
    private final Scanner scanner;
    private final String message;

    public InputReader(PrintStream printStream, Scanner scanner, String message) {
        this.printStream = printStream;
        this.scanner = scanner;
        this.message = message;
    }

    public String read() {
        printStream.println(message);
        return scanner.nextLine();
    }
}
