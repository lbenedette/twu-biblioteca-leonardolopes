package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.services.BookCheckoutService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookCheckoutServiceTest {

    @Test
    public void checkoutBookAndChangeItAvailableStatusTest() throws BookNotFoundException {
        BookCollection bookCollection = mock(BookCollection.class);
        BookReader bookReader = mock(BookReader.class);
        BookCheckoutService bookCheckoutService = new BookCheckoutService(bookCollection, bookReader);

        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954");
        List<Book> books = new ArrayList<>();
        books.add(book);

        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.getAvailableBooks()).thenReturn(books);
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        bookCheckoutService.call();

        assertThat(false, is(book.isAvailable()));
    }

}
