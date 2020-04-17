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

    private final Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
    private List<Book> books;
    private BookCollection bookCollection;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        bookCollection = new BookCollection(books);
    }

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
        books.add(book);

        bookCollection.listBooks();

        String[] rows = outContent.toString().split("\n");
        String header = rows[0];
        String bookRow = rows[1];
        assertThat(header, is(String.format("%-40s%-40s%-40s", "Title", "Author", "Year Published")));
        assertThat(bookRow, is(String.format("%-40s%-40s%-40s", "The Fellowship Of The Ring", "J. R. R. Tolkien", "1954")));
    }

    @Test
    public void shouldPrintNothingWhenBookListIsEmpty() {
        bookCollection.listBooks();

        assertThat(outContent.toString(), is(""));
    }

    @Test
    public void shouldFindBookByTitle() {
        books.add(book);

        Book foundBook = bookCollection.findByTitle("The Fellowship Of The Ring");

        assertThat(book, is(foundBook));
    }

    @Test
    public void shouldReturnNullWhenBookDontExist() {
        Book foundBook = bookCollection.findByTitle("The Two Towers");

        assertThat(null, is(foundBook));
    }

    @Test
    public void shouldCheckoutBookAndChangeItStatus() {
        books.add(book);

        bookCollection.checkoutBook(book);

        assertThat(false, is(book.isAvailable()));
    }
}
