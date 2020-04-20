package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import org.junit.Before;
import org.junit.Test;


import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class BookCheckoutServiceTest {
    private final Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
    private BookCollection bookCollection;
    private BookReader bookReader;
    private PrintStream printStream;
    private BookCheckoutService bookCheckoutService;

    @Before
    public void setUp() {
        bookCollection = mock(BookCollection.class);
        bookReader = mock(BookReader.class);
        printStream = mock(PrintStream.class);
        bookCheckoutService = new BookCheckoutService(bookCollection, bookReader, printStream);
    }

    @Test
    public void checkoutBookAndChangeItAvailableStatusTest() {
        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        bookCheckoutService.call();

        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void showSuccessfulMessageAfterCheckoutABookTest() {
        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        bookCheckoutService.call();

        verify(printStream).println("Thank you! Enjoy the book");
    }
}
