package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class BookCheckinServiceTest {
    private final Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", false);
    private BookCollection bookCollection;
    private BookReader bookReader;
    private PrintStream printStream;
    private BookCheckinService bookCheckinService;

    @Before
    public void setUp() {
        bookCollection = mock(BookCollection.class);
        bookReader = mock(BookReader.class);
        printStream = mock(PrintStream.class);
        bookCheckinService = new BookCheckinService(bookCollection, bookReader, printStream);
    }

    @Test
    public void checkinBookAndMakeAvailableTest() {
        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);

        bookCheckinService.call();

        assertThat(book.isAvailable(), is(true));
    }

    @Test
    public void showSuccessfulMessageWhenReturnABookTest() {
        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);

        bookCheckinService.call();

        verify(printStream).println("Thank you for returning the book");
    }
}
