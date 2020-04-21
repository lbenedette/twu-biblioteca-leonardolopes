package com.twu.biblioteca.services;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.book.BookCollection;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.fakes.FakeReader;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class BookCheckoutServiceTest {
    private Book book;
    private BookCollection bookCollection;
    private FakeReader fakeReader;
    private PrintStream printStream;
    private BookCheckoutService bookCheckoutService;

    @Before
    public void setUp() {
        book = mock(Book.class);
        bookCollection = mock(BookCollection.class);
        fakeReader = mock(FakeReader.class);
        printStream = mock(PrintStream.class);
        bookCheckoutService = new BookCheckoutService(bookCollection, fakeReader, printStream);
    }

    @Test
    public void checkoutBookAndChangeItAvailableStatusTest() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", true);

        when(fakeReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);

        bookCheckoutService.call();

        assertThat(book.isAvailable(), is(false));
    }

    @Test
    public void showSuccessfulMessageAfterCheckoutABookTest() {
        when(fakeReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        when(book.isAvailable()).thenReturn(true);

        bookCheckoutService.call();

        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void showErrorMessageAfterCantCheckoutABookTest() {
        when(fakeReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        when(book.isAvailable()).thenReturn(false);

        bookCheckoutService.call();

        verify(printStream).println("Sorry, that book is not available");
    }

    @Test
    public void showErrorMessageWhenBookIsNotFoundTest() {
        when(fakeReader.read()).thenReturn("The Two Towers");
        when(bookCollection.findByTitle("The Two Towers")).thenThrow(new BookNotFoundException("Book not found!"));

        bookCheckoutService.call();

        verify(printStream).println("Book not found!");
    }
}
