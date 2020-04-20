package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class BookReaderTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private BookReader bookReader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        bookReader = new BookReader(printStream, bufferedReader);
    }

    @Test
    public void showMessageToEnterBookTitleTest() {
        bookReader.read();

        verify(printStream).println("Enter book title: ");
    }

    @Test
    public void readFromConsoleBookTitleTest() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Fellowship Of The Ring");

        assertThat(bookReader.read(), is("The Fellowship Of The Ring"));
    }
}
