package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GreetingPrinterTest {

    @Test
    public void printWelcomeMessageTest() {
        PrintStream printStream = mock(PrintStream.class);
        GreetingPrinter greetingPrinter = new GreetingPrinter(printStream);

        greetingPrinter.greeting();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
