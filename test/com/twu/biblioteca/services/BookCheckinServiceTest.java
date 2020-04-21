package com.twu.biblioteca.services;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.book.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
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

    @Test
    public void showErrorMessageWhenTryReturnABookThatIsAlreadyAvailableTest() {
        Book availableBook = new Book("The Two Towers", "J. R. R. Tolkien", "1945", true);

        when(bookReader.read()).thenReturn("The Two Towers");
        when(bookCollection.findByTitle("The Two Towers")).thenReturn(availableBook);

        bookCheckinService.call();

        verify(printStream).println("That is not a valid book to return");
    }

    @Test
    public void showErrorMessageWhenBookIsNotFoundTest() {
        when(bookReader.read()).thenReturn("The Two Towers");
        when(bookCollection.findByTitle("The Two Towers")).thenThrow(new BookNotFoundException("Book not found!"));

        bookCheckinService.call();

        verify(printStream).println("Book not found!");
    }
}
