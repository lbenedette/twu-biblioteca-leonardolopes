package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class InputReader {
    private final PrintStream printStream;
    private final BufferedReader bufferedReader;

    public InputReader(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public String read() {
        printStream.println("Enter a option: ");
        return readLine();
    }

    private String readLine() {
        String book = null;
        try {
            book = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }
}
