package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LibraryTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void setDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test
    public void shouldPrintWelcomeMessageOnRun() {
        List<String> books = new ArrayList<>();
        Library library = new Library(books);

        library.run();

        String firstLine = outContent.toString().split("\n")[0];
        assertThat(firstLine, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldPrintABookListAfterWelcomeMessage() {
        List<String> books = new ArrayList<>();
        Library library = new Library(books);

        books.add("The Fellowship Of The Ring");
        library.run();

        String secondLine = outContent.toString().split("\n")[1];
        assertThat(secondLine, is("The Fellowship Of The Ring"));
    }

    @Test
    public void shouldPrintNothingAfterWelcomeMessageIfBooksIsEmpty() {
        List<String> books = new ArrayList<>();
        Library library = new Library(books);

        library.run();

        assertThat(outContent.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }
}
