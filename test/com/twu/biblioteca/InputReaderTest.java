package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class InputReaderTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private InputReader inputReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        inputReader = new InputReader(printStream, bufferedReader);
    }

    @Test
    public void showMessageToEnterBookTitleTest() {
        inputReader.read();

        verify(printStream).println("Enter a option: ");
    }

    @Test
    public void readFromConsoleBookTitleTest() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Fellowship Of The Ring");

        assertThat(inputReader.read(), is("The Fellowship Of The Ring"));
    }
}
