package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class InputReaderTest {
    @Rule
    public final TextFromStandardInputStream in = emptyStandardInputStream();

    private PrintStream printStream;
    private Scanner scanner;
    private InputReader inputReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        scanner = new Scanner(System.in);
        inputReader = new InputReader(printStream, scanner, "Enter something for me read: ");
    }

    @Test
    public void showMessageBeforeReadFromConsoleTest() {
        in.provideLines("Text");

        inputReader.read();

        verify(printStream).println("Enter something for me read: ");
    }

    @Test
    public void readFromConsoleTest() {
        in.provideLines("The Fellowship Of The Ring");

        assertThat(inputReader.read(), is("The Fellowship Of The Ring"));
    }
}
