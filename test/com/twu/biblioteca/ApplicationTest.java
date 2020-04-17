package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ApplicationTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private BookCollection bookCollection;
    private BufferedReader bufferedReader;
    private Application app;

    @Before
    public void setUpStreams() throws Exception {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() throws Exception {
        bookCollection = mock(BookCollection.class);
        bufferedReader = mock(BufferedReader.class);
        app = new Application(bookCollection, bufferedReader);
    }

    @After
    public void setDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        app.printGreeting();

        assertThat(outContent.toString(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n"));
    }

    @Test
    public void shouldPrintMenuWithOptions() {
        app.printMenu();

        String menu = "MENU\n1 - List of books\n0 - Exit application\n\n";
        assertThat(outContent.toString(), is(menu));
    }

    @Test
    public void shouldListBookWhenUserChooseListOfBooks() throws IOException {
        String option = "1";
        app.executeAction(option);

        verify(bookCollection).listBooks();
    }

    @Test
    public void shouldShowAErrorMessageWhenEnteredAInvalidOption() throws IOException {
        String option = "9";
        app.executeAction(option);

        assertThat(outContent.toString(), containsString("Please select a valid option!"));
    }
}
