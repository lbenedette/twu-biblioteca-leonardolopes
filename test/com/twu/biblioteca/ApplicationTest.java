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


public class ApplicationTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private List<Book> books;
    private BookCollection bookCollection;
    private Application app;

    @Before
    public void setUpStreams() throws Exception {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        bookCollection = new BookCollection(books);
        app = new Application(bookCollection);
    }

    @After
    public void setDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test
    public void shouldPrintWelcomeMessageOnRun() {
        app.run();

        assertThat(outContent.toString().split("\n")[0], is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldPrintMenuWithOptions() {
        app.printMenu();

        String menu = "MENU\n1 - List of books\n";
        assertThat(outContent.toString(), is(menu));
    }

    @Test
    public void shouldPrintMenuAfterTheWelcomeMessage() {
        app.run();

        String[] rows = outContent.toString().split("\n");
        String welcomeMessage = rows[0];
        String menu = rows[1];
        String firstOption = rows[2];
        assertThat(welcomeMessage, is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
        assertThat(menu, is("MENU"));
        assertThat(firstOption, is("1 - List of books"));
    }
}
