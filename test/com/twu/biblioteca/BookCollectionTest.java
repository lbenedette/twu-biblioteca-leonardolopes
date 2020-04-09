package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookCollectionTest {
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
    public void shouldPrintBookListInATableFormatWithHeader() {
        List<Book> books = new ArrayList<>();
        BookCollection bookCollection = new BookCollection(books);
        books.add(new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954"));

        bookCollection.listBooks();

        String[] rows = outContent.toString().split("\n");
        String header = rows[0];
        String bookRow = rows[1];
        assertThat(header, is(String.format("%-40s%-40s%-40s", "Title", "Author", "Year Published")));
        assertThat(bookRow, is(String.format("%-40s%-40s%-40s", "The Fellowship Of The Ring", "J. R. R. Tolkien", "1954")));
    }

    @Test
    public void shouldPrintNothingWhenBookListIsEmpty() {
        List<Book> books = new ArrayList<>();
        BookCollection bookCollection = new BookCollection(books);

        bookCollection.listBooks();

        assertThat(outContent.toString(), is(""));
    }
}
