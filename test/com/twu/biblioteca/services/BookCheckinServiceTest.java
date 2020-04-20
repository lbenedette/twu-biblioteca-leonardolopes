package com.twu.biblioteca.services;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookCollection;
import com.twu.biblioteca.BookReader;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookCheckinServiceTest {

    @Test
    public void checkinBookAndMakeAvailableTest() {
        Book book = new Book("The Fellowship Of The Ring", "J. R. R. Tolkien", "1954", false);

        BookCollection bookCollection = mock(BookCollection.class);
        BookReader bookReader = mock(BookReader.class);
        BookCheckinService bookCheckinService = new BookCheckinService(bookCollection, bookReader);

        when(bookReader.read()).thenReturn("The Fellowship Of The Ring");
        when(bookCollection.findByTitle("The Fellowship Of The Ring")).thenReturn(book);
        bookCheckinService.call();

        assertThat(book.isAvailable(), is(true));
    }
}
