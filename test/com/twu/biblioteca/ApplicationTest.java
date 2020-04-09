package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class ApplicationTest {
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() throws Exception {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void setDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test
    public void shouldPrintWelcomeMessageOnRun() {
        BookCollection bookCollection = new BookCollection();
        Application app = new Application(bookCollection);

        app.run();

        assertThat(outContent.toString().split("\n")[0], is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void shouldHaveABookCollection() {
        BookCollection bookCollection = new BookCollection();
        Application app = new Application(bookCollection);

        assertThat(bookCollection, is(app.getBookCollection()));
    }
}
